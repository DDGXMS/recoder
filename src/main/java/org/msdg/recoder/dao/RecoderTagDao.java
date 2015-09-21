package org.msdg.recoder.dao;

import org.msdg.recoder.model.RecoderTag;
import org.msdg.recoder.model.RecoderType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 小梦 on 2015/9/21.
 */
@Repository
public interface RecoderTagDao {

    List<RecoderTag> getAllRecoderTag(int creator);

    RecoderTag getRecoderTag(int id);

    void addRecoderTag(RecoderTag tag);

    void updateRecoderTag(RecoderTag newTag);

    void deleteRecoderTag(int id);
}
