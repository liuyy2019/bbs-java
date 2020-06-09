package com.yang.bbs.controller;

import com.yang.bbs.bean.EnumType;
import com.yang.bbs.bean.dto.EnumTypeReq;
import com.yang.bbs.service.EnumTypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/22 16:42
 */
@RestController
@RequestMapping("/v1")
public class EnumTypeController {

    @Autowired
    private EnumTypeService enumTypeService;

    /**
     * 获取所有的枚举类型信息
     * @return
     */
    @ApiOperation(value = "获取所有的枚举类型信息")
    @GetMapping("/enum/typeList")
    public List<EnumType> getAllEnumType(){
        return enumTypeService.selectAll();
    }

    /**
     * 分页动态的获取枚举类型信息
     * @return
     */
    @ApiOperation(value = "分页动态的获取枚举类型信息")
    @PostMapping("/enum/enumType/page")
    public List<EnumType> enumTypeList(
            @ApiParam("请求对象实体")
            @RequestBody EnumTypeReq enumTypeReq){
        List<EnumType> enumTypeList =
                enumTypeService.selectList(enumTypeReq.getEnumType(),enumTypeReq.getPage(),enumTypeReq.getSize());
        return enumTypeList;
    }

    /**
     * 根据id删除枚举类型信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除枚举类型信息")
    @DeleteMapping("/enum/enumType/{id}")
    public Boolean deleteEnumType(@PathVariable("id") Integer id){
        return enumTypeService.deleteEnumTypeById(id);
    }

    /**
     *  添加枚举类型信息
     * @param enumType
     * @return
     */
    @ApiOperation(value = "添加枚举类型信息")
    @PostMapping("/enumType/add")
    public Boolean addEnumType(@RequestBody EnumType enumType) {
        return enumTypeService.addEnumType(enumType);
    }

    /**
     *  更新枚举类型信息
     * @param enumType
     * @return
     */
    @ApiOperation(value = "更新枚举类型信息")
    @PutMapping("/enumType/update")
    public Boolean updateEnumType(@RequestBody EnumType enumType) {
        return enumTypeService.updateEnumType(enumType);
    }

}
