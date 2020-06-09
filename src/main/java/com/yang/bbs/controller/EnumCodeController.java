package com.yang.bbs.controller;

import com.yang.bbs.bean.EnumCode;
import com.yang.bbs.bean.dto.EnumCodeReq;
import com.yang.bbs.service.EnumCodeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/22 16:51
 */
@RequestMapping("/v1")
@RestController
public class EnumCodeController {

    @Autowired
    private EnumCodeService enumCodeService;

    /**
     * 获取所有的枚举码信息
     * @return
     */
    @ApiOperation(value = "获取所有的枚举码信息")
    @GetMapping("/enumCode/enumCodeList")
    public List<EnumCode> getAllAnswer(){
        return enumCodeService.selectAll();
    }

    /**
     * 通过枚举码动态获取对应的信息
     * @param enumCode
     * @return
     */
    @ApiOperation(value = "通过枚举码动态获取对应的信息")
    @PostMapping("/enumCode/codeList")
    public List<EnumCode> codeListByType(@RequestBody EnumCode enumCode){
        return enumCodeService.codeListByType(enumCode);
    }

    /**
     * 分页动态的获取枚举码信息
     * @return
     */
    @ApiOperation(value = "分页动态的获取枚举码信息")
    @PostMapping("/enum/enumCode/page")
    public List<EnumCode> adminList(
            @ApiParam("请求对象实体")
            @RequestBody EnumCodeReq enumCodeReq){
        List<EnumCode> enumCodeList = enumCodeService.selectList(enumCodeReq.getEnumCode(),enumCodeReq.getPage(),enumCodeReq.getSize());
        return enumCodeList;
    }

    /**
     * 根据id删除枚举码信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除枚举码信息")
    @DeleteMapping("/enum/enumCode/{id}")
    public Boolean deleteEnumCode(@PathVariable("id") Integer id){
        return enumCodeService.deleteEnumCodeById(id);
    }

    /**
     *  添加枚举码信息
     * @param enumCode
     * @return
     */
    @ApiOperation(value = "添加枚举码信息")
    @PostMapping("/enumCode/add")
    public Boolean addEnumCode(@RequestBody EnumCode enumCode) {
        return enumCodeService.addEnumCode(enumCode);
    }

    /**
     *  更新枚举码信息
     * @param enumCode
     * @return
     */
    @ApiOperation(value = "更新枚举码信息")
    @PutMapping("/enumCode/update")
    public Boolean updateEnumCode(@RequestBody EnumCode enumCode) {
        return enumCodeService.updateEnumCode(enumCode);
    }

}
