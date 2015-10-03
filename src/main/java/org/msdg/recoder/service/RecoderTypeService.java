package org.msdg.recoder.service;

import org.msdg.recoder.dao.RecoderTypeDao;
import org.msdg.recoder.model.RecoderType;
import org.msdg.recoder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22.
 */
@Service
public class RecoderTypeService {

    @Autowired
    private RecoderTypeDao recoderTypeDao;

    public List<RecoderType> allTypes(int creator) {
        return recoderTypeDao.getAllRecoderType(creator);
    }
    public RecoderType add(RecoderType recoderType, User user) {
        recoderType.setCreator(user.getId());
        recoderTypeDao.addRecoderType(recoderType);
        return recoderType;
    }
}
