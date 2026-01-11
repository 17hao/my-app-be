package xyz.shiqihao.investment.model;

import java.math.BigDecimal;
import java.util.Currency;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OpAmount {

    /**
     * 数值
     */
    private BigDecimal number;


    /**
     * 币种
     */
    private Currency currency;

    /**
     * 等额人民币
     */
    private BigDecimal equivalentCny;

}
