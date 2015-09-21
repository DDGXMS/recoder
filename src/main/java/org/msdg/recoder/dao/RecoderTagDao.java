package org.msdg.recoder.dao;

import org.msdg.recoder.model.RecoderTag;

/**
 * Created by 小梦 on 2015/9/21.
 */
public interface RecoderTagDao {

    RecoderTag getRecoderTag(int id);

    void addRecoderTag(RecoderTag tag);

    void updateRecoderTag(RecoderTag newTag);

    void deleteRecoderTag(int id);
}
