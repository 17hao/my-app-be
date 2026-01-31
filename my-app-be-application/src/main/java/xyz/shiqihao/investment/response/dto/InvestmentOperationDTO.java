package xyz.shiqihao.investment.response.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.shiqihao.investment.model.InvestmentOperation;

@Setter
@Getter
public class InvestmentOperationDTO {

    private String id;

    private String opDate;

    private String opPlatform;

    private String opType;

    private InvestmentOperation.OpItem opItem;

    private InvestmentOperation.OpAmount opAmount;

}
