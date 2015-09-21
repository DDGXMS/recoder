package org.msdg.recoder.dao;

import org.msdg.recoder.model.Recoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/21.
 */
@Repository
public interface RecoderDao {

    /**
     * 获取recoder的分页信息
     * @param parmas    查询参数，包括：
     *                  pageNo      页码
     *                  pageSize    页容
     *                  creator     所属用户
     *                  keyword     查询关键字
     *                  tags        包含的标签
     *                  recoderType 所属分类
     * @return          符合信息的recoder列表，按最近修改时间倒序
     */
    List<Recoder> getRecoderPage(Map<String, Object> parmas);

    void addRecoder(Recoder recoder);

    void updateRecoder(Recoder newRecoder);

    void deleteRecoder(int id);
}
