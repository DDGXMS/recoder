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

    public Recoder add(Recoder recoder, User user) {
        recoder.setCreator(user.getId());
        recoderDao.addRecoder(recoder);
        return recoder;
    }
}
