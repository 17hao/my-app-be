package xyz.shiqihao.investment.model;

import lombok.Getter;
import lombok.Setter;

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
