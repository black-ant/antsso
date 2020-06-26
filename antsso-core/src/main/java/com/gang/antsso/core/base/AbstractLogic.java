package com.gang.antsso.core.base;

import com.gang.antsso.datacenter.entity.AbstractAntSsoEntity;
import com.gang.antsso.to.BaseAntSsoTO;
import com.gang.common.lib.utils.ReflectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AbstractLogic
 * @Description TODO
 * @Date 2020/6/26 15:53
 * @Created by zengzg
 */
public abstract class AbstractLogic<T extends JpaRepository, E extends AbstractAntSsoEntity, O extends BaseAntSsoTO> {

    @Autowired
    private ReflectionUtils reflectionUtils;

    public O get(String key) {
        E entity = getRepository().getOne(key);
        return conversionTO(entity);
    }

    public List<O> list() {
        return conversionTOList(getRepository().findAll());
    }

    public String delete(String key) {
        getRepository().deleteById(key);
        return key;
    }

    @Transactional
    public O insert(BaseAntSsoTO baseTO) {
        E back = getRepository().save(conversionEntity(baseTO));
        return conversionTO(back);
    }

    public O update(BaseAntSsoTO baseTO) {
        E back = getRepository().saveAndFlush(conversionEntity(baseTO));
        return conversionTO(back);
    }

    public JpaRepository<E, String> getRepository() {
        Class clazz = reflectionUtils.getClassRealType(this.getClass(), 1);
        return reflectionUtils.springClassLoad(clazz.getName());
    }


    /**
     * @param baseTO
     * @return
     */
    public E conversionEntity(BaseAntSsoTO baseTO) {
        Class clazz = reflectionUtils.getClassRealType(this.getClass(), 2);
        E ssoEntity = reflectionUtils.springClassLoad(clazz.getName());
        BeanUtils.copyProperties(baseTO, ssoEntity);
        return ssoEntity;
    }

    /**
     * @param entitys
     * @return
     */
    public List<O> conversionTOList(List<E> entitys) {
        List<O> backList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(entitys)) {
            entitys.forEach(item -> {
                backList.add(conversionTO(item));
            });
        }
        return backList;
    }

    /**
     * @param entity
     * @return
     */
    public O conversionTO(AbstractAntSsoEntity entity) {
        Class clazz = reflectionUtils.getClassRealType(this.getClass(), 3);
        O baseAntSsoTO = reflectionUtils.springClassLoad(clazz.getName());
        BeanUtils.copyProperties(entity, baseAntSsoTO);
        return baseAntSsoTO;
    }


}
