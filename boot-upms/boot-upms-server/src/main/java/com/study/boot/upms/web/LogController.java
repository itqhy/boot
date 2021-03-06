package com.study.boot.upms.web;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.boot.common.util.WebResponse;
import com.study.boot.upms.api.entity.SysLog;
import com.study.boot.upms.service.SysLogService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/log")
@AllArgsConstructor
@Api(tags = "日志管理模块")
public class LogController {

    private final SysLogService sysLogService;

    /**
     * 分页查询日志
     * @param page
     * @param sysLog
     * @return
     */
    @GetMapping("/page")
    public WebResponse getLogPage(Page page, SysLog sysLog) {
        return new WebResponse<>(sysLogService.page(page, Wrappers.query(sysLog)));
    }

    /**
     * 删除日志
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_log_del')")
    public WebResponse removeLogById(@PathVariable Integer id) {
        return new WebResponse<>(sysLogService.removeById(id));
    }

    /**
     * 保存日志
     * @param sysLog
     * @return
     */
    @PostMapping
    public WebResponse saveLog(@Valid @RequestBody SysLog sysLog) {
        return new WebResponse<>(sysLogService.save(sysLog));
    }
}
