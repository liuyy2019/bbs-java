package com.yang.bbs.controller;

import com.yang.bbs.bean.Param;
import com.yang.bbs.bean.dto.ParamReq;
import com.yang.bbs.service.ParamService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/21 16:55
 */
@RequestMapping("/v1")
@RestController
public class ParamController {

    @Autowired
    private ParamService paramService;

    /**
     * 获取所有的参数信息
     * @return
     */
    @ApiOperation(value = "获取所有的参数信息")
    @GetMapping("/param/paramList")
    public List<Param> getAllParam(){
        return paramService.selectAll();
    }

    /**
     * 根据参数码获取参数信息
     * @return
     */
    @ApiOperation(value = "获取所有的参数信息")
    @GetMapping("/param/codeId")
    public Param getParamByCodeId(@RequestParam String codeId){
        return paramService.selectByCodeId(codeId);
    }

    /**
     * 分页动态的获取参数信息
     * @return
     */
    @ApiOperation(value = "分页动态的获取参数信息")
    @PostMapping("/param/param/page")
    public List<Param> paramList(
            @ApiParam("请求对象实体")
            @RequestBody ParamReq paramReq){
        List<Param> paramList = paramService.selectList(paramReq.getParam(),paramReq.getPage(),paramReq.getSize());
        return paramList;
    }

    /**
     * 根据id删除参数信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除参数信息")
    @DeleteMapping("/param/param/{id}")
    public Boolean deleteParam(@PathVariable("id") Integer id){
        return paramService.deleteParamById(id);
    }

    /**
     *  添加参数信息
     * @param param
     * @return
     */
    @ApiOperation(value = "添加参数信息")
    @PostMapping("/param/add")
    public Boolean addParam(@RequestBody Param param) {
        return paramService.addParam(param);
    }

    /**
     *  更新参数信息
     * @param param
     * @return
     */
    @ApiOperation(value = "更新参数信息")
    @PutMapping("/param/update")
    public Boolean updateParam(@RequestBody Param param) {
        return paramService.updateParam(param);
    }

}
