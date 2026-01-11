package xyz.shiqihao.investment.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.common.ControllerTemplate;
import xyz.shiqihao.common.HttpResponse;
import xyz.shiqihao.investment.request.CreateInvestmentOperationRequest;
import xyz.shiqihao.investment.response.CreateInvestmentOperationResponse;
import xyz.shiqihao.investment.response.InvestmentAnalyzeResponse;
import xyz.shiqihao.investment.response.InvestmentOperationResponse;
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
     * 查询 InvestmentOperation 列表：过滤已删除，按操作期倒序
     */
    @GetMapping("/operations")
    public HttpResponse<List<InvestmentOperationResponse>> getOperationList() {
        return new ControllerTemplate<List<InvestmentOperationResponse>>() {
            @Override
            public List<InvestmentOperationResponse> biz() throws Exception {
                return investmentOperationService.getOperationList();
            }
        }.exec();
    }

    /**
     * 汇总分析（过滤已删除）。
     */
    @GetMapping("/analyze")
    public HttpResponse<InvestmentAnalyzeResponse> analyze() {
        return new ControllerTemplate<InvestmentAnalyzeResponse>() {
            @Override
            public InvestmentAnalyzeResponse biz() throws Exception {
                return investmentOperationService.analyze();
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
