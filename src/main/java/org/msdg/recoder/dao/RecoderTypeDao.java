package org.msdg.recoder.dao;

import org.msdg.recoder.model.RecoderType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/9/21.
 */
@Repository
public interface RecoderTypeDao {

    List<RecoderType> getAllRecoderType(int creator);

    RecoderType getRecoderType(int id);

    void addRecoderType(RecoderType tag);

    void updateRecoderType(RecoderType newTag);

    void deleteRecoderType(int id);
}
