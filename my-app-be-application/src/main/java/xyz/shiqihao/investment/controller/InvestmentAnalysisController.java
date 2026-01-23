package xyz.shiqihao.investment.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.common.web.ControllerTemplate;
import xyz.shiqihao.common.web.HttpResponse;
import xyz.shiqihao.investment.response.InvestmentAnalyzeCostResponse;
import xyz.shiqihao.investment.service.InvestmentAnalysisService;

@RestController
@RequestMapping("/investment")
@AllArgsConstructor
@Log4j2
public class InvestmentAnalysisController {

    private final InvestmentAnalysisService investmentAnalysisService;

    /**
     * 成本分析
     */
    @GetMapping({"/analyze/cost"})
    public HttpResponse<InvestmentAnalyzeCostResponse> analyzeCost() {
        return new ControllerTemplate<InvestmentAnalyzeCostResponse>() {
            @Override
            public InvestmentAnalyzeCostResponse biz() throws Exception {
                return investmentAnalysisService.analyzeCost();
            }
        }.exec();
    }


}
