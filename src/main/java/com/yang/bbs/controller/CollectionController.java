package com.yang.bbs.controller;

import com.yang.bbs.bean.Collection;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.CollectionReq;
import com.yang.bbs.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/21 1:03
 */
@RestController
@RequestMapping("/v1")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 获取所有的收藏列表
     * @return
     */
    @GetMapping("/collection/allCollections")
    public List<Collection> getAllCollection(){
        return collectionService.selectAll();
    }

    /**
     * 动态的获取收藏信息列表
     * @return
     */
    @PostMapping("/collection/collection/page")
    public List<Collection> collectionList(@RequestBody CollectionReq collectionReq){
        List<Collection> collectionList = collectionService.selectList(collectionReq.getCollection(),collectionReq.getPage(),collectionReq.getSize());
        return collectionList;
    }

    /**
     * 根据id查询收藏信息
     * @param id
     * @return
     */
    @DeleteMapping("/collection/{id}")
    public Boolean deleteUser(@PathVariable("id") Integer id){
        return collectionService.deleteUserById(id);
    }

    /**
     *  添加收藏信息
     * @param user
     * @return
     */
    @PostMapping("/collection/add")
    public Boolean addCollection(@RequestBody Collection user) {
        return collectionService.addCollection(user);
    }

    /**
     *  更新收藏信息
     * @param user
     * @return
     */
    @PutMapping("/collection/update")
    public Boolean updateCollection(@RequestBody Collection user) {
        return collectionService.updateCollection(user);
    }
}
