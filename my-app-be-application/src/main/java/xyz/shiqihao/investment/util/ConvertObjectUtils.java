package xyz.shiqihao.investment.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.shiqihao.investment.model.InvestmentOperation;
import xyz.shiqihao.investment.model.InvestmentOperationDTO;
import xyz.shiqihao.investment.repository.model.InvestmentOperationDO;

public class ConvertObjectUtils {

    public static InvestmentOperation convertToVO(InvestmentOperationDO dataObj) throws JsonProcessingException {
        InvestmentOperation res = new InvestmentOperation();

        ObjectMapper om = new ObjectMapper();

        InvestmentOperation.OpItem opItem =
                om.readValue(dataObj.getOpItem(), InvestmentOperation.OpItem.class);

        InvestmentOperation.OpAmount opAmount =
                om.readValue(dataObj.getOpAmount(), InvestmentOperation.OpAmount.class);

        res.setId(String.valueOf(dataObj.getId()));
        res.setOpDate(dataObj.getOpDate());
        res.setOpPlatform(InvestmentOperation.OpPlatform.valueOf(dataObj.getOpPlatform()));
        res.setOpType(InvestmentOperation.OpType.valueOf(dataObj.getOpType()));
        res.setOpItem(opItem);
        res.setOpAmount(opAmount);
        return res;
    }

    public static InvestmentOperationDTO convertToDTO(InvestmentOperation model) throws JsonProcessingException {
        InvestmentOperationDTO res = new InvestmentOperationDTO();
        res.setId(String.valueOf(model.getId()));
        res.setOpDate(model.getOpDate().toString());
        res.setOpPlatform(model.getOpPlatform().name().toLowerCase());
        res.setOpType(model.getOpType().name().toLowerCase());
        res.setOpItem(model.getOpItem());
        res.setOpAmount(model.getOpAmount());
        return res;
    }

}
