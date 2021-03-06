package com.study.boot.upms.web;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.boot.common.annotation.SysLog;
import com.study.boot.common.util.WebResponse;
import com.study.boot.upms.api.entity.SysDict;
import com.study.boot.upms.service.SysDictService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 字典表 前端控制器
 * @author Administrator
 */
@RestController
@RequestMapping("/dict")
@AllArgsConstructor
@Api(tags = "字典管理模块")
public class DictController {

    private final SysDictService sysDictService;


    /**
     * 通过ID查询字典信息
     *
     * @param id ID
     * @return 字典信息
     */
    @GetMapping("/{id}")
    public WebResponse getDictById(@PathVariable Integer id) {
        return new WebResponse<>(sysDictService.getById(id));
    }

    /**
     * 分页查询字典信息
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public WebResponse<IPage> getDictPage(Page page, SysDict sysDict) {
        return new WebResponse<>(sysDictService.page(page,Wrappers.query(sysDict)));
    }


    /**
     * 添加字典
     *
     * @param sysDict 字典信息
     * @return success、false
     */
    @SysLog("添加字典")
    @PostMapping
    @PreAuthorize("@pms.hasPermission('sys_dict_add')")
    public WebResponse save(@Valid @RequestBody SysDict sysDict) {
        return new WebResponse<>(sysDictService.save(sysDict));
    }

    /**
     * 删除字典，并且清除字典缓存
     *
     * @param id   ID
     * @return WebResponse
     */
    @SysLog("删除字典")
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_dict_del')")
    public WebResponse removeById(@PathVariable Integer id) {
        return new WebResponse<>(sysDictService.removeById(id));
    }

    /**
     * 修改字典
     *
     * @param sysDict 字典信息
     * @return success/false
     */
    @PutMapping
    @SysLog("修改字典")
    @PreAuthorize("@pms.hasPermission('sys_dict_edit')")
    public WebResponse updateById(@Valid @RequestBody SysDict sysDict) {
        return new WebResponse<>(sysDictService.updateById(sysDict));
    }

}
