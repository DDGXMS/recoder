package org.msdg.recoder.service;

import org.apache.commons.lang3.StringUtils;
import org.msdg.framework.Constants;
import org.msdg.framework.syntactic.SugarMap;
import org.msdg.recoder.dao.RecoderDao;
import org.msdg.recoder.model.Recoder;
import org.msdg.recoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/9/21.
 */
@Service
public class RecoderService {

    @Autowired
    private RecoderDao recoderDao;

    public List<Recoder> recoderPage(int pageNo, int creator, String keyword, String tags, String type) {
        Map<String, Object> params = SugarMap.paramMap("offset", (pageNo-1)*Constants.PAGE_SIZE, "pageSize", Constants.PAGE_SIZE,
                "creator", creator, "keyword", keyword, "recoderType", type);
        if (StringUtils.isNoneBlank(tags)) {
            String[] tagSplit = tags.split(",");
            List<String> tagList = new ArrayList<>(tagSplit.length);
            for (String tag : tagSplit) {
                tagList.add(tag);
            }
            params.put("tags", tagList);
        }
        return recoderDao.getRecoderPage(params);
    }

    public Recoder getRecoder(int id) {
        return recoderDao.getRecoder(id);
    }

    public Recoder add(Recoder recoder, User user) {
        completeText(recoder);

        recoder.setCreator(user.getId());
        recoderDao.addRecoder(recoder);
        return recoder;
    }

    public void delete(int id) {
        recoderDao.deleteRecoder(id);
    }

    public void update(Recoder recoder) {
        completeText(recoder);
        recoderDao.updateRecoder(recoder);
    }

    public void changeLove(int id) {
        recoderDao.changeLove(id);
    }

    /**
     * 去处content中的html标签
     * 放入text字段
     */
    private void completeText(Recoder recoder) {
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(recoder.getContent());
        recoder.setText(matcher.replaceAll(" "));
    }
}
