package xyz.shiqihao.investment.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.common.util.AssertUtils;
import xyz.shiqihao.common.web.ControllerTemplate;
import xyz.shiqihao.common.web.HttpResponse;
import xyz.shiqihao.common.web.PageRequest;
import xyz.shiqihao.investment.request.CreateInvestmentOperationRequest;
import xyz.shiqihao.investment.response.CreateInvestmentOperationResponse;
import xyz.shiqihao.investment.response.PageQueryInvestmentOperationResponse;
import xyz.shiqihao.investment.service.InvestmentOperationService;

@RestController
@RequestMapping("/investment")
@AllArgsConstructor
@Log4j2
public class InvestmentOperationController {
    private final InvestmentOperationService investmentOperationService;

    /**
     * 新增 InvestmentOperation 记录
     */
    @PostMapping("/operation")
    public HttpResponse<CreateInvestmentOperationResponse> createOperation(
            @RequestBody CreateInvestmentOperationRequest request
    ) {
        return new ControllerTemplate<CreateInvestmentOperationResponse>() {
            @Override
            public CreateInvestmentOperationResponse biz() throws Exception {
                long id = investmentOperationService.createOperation(request);
                return new CreateInvestmentOperationResponse(String.valueOf(id));
            }
        }.exec();
    }

    /**
     * 分页查询 InvestmentOperation 列表，按操作日期倒序。
     */
    @PostMapping("/operations")
    public HttpResponse<PageQueryInvestmentOperationResponse> getOperationList(
            @RequestBody PageRequest request
    ) {
        return new ControllerTemplate<PageQueryInvestmentOperationResponse>() {
            @Override
            public PageQueryInvestmentOperationResponse biz() throws Exception {
                AssertUtils.isNonNull(request);
                AssertUtils.isTrue(request.getPageNum() != null && request.getPageNum() > 0);
                AssertUtils.isTrue(request.getPageSize() != null && request.getPageSize() > 0
                        && request.getPageSize() <= 20);

                return investmentOperationService.getOperationListPage(request.getPageNum(), request.getPageSize());
            }
        }.exec();
    }

    /**
     * 删除（软删除）一条 InvestmentOperation 记录
     */
    @DeleteMapping("/operation/{id}")
    public HttpResponse<Boolean> deleteOperation(@PathVariable String id) {
        return new ControllerTemplate<Boolean>() {
            @Override
            public Boolean biz() {
                investmentOperationService.deleteOperation(Long.parseLong(id));
                return true;
            }
        }.exec();
    }
}

