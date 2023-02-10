package com.gerry.asset.controller;

import com.gerry.asset.dto.AssertDTO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Gerry
 */
@RestController
public class AssertComputeController {

    private static final Logger logService = LogManager.getLogger(AssertComputeController.class);

    @GetMapping(value = "getAssetsAndGetMoney/json")
    public String getAssetsAndGetMoney(@RequestBody AssertDTO assertDTO) {
        Map<Integer, Double> everyYearsRebate = new HashMap<Integer, Double>();
        if (assertDTO == null || assertDTO.getInitAssert() <= 0 || assertDTO.getYears() <= 0 || assertDTO.getRate() <= 0.0) {
            return "不好意思，您输入错误，请重新输入投资金额，投资年限和您期望的年利率";
        }

        StringBuilder sb = new StringBuilder();

        Double initAssets = assertDTO.getInitAssert();
        Integer n = assertDTO.getYears();
        Double rate = assertDTO.getRate();

        try {
            for (int i = 0; i < n; i++) {
                everyYearsRebate.put(i, initAssets * 6 / 100);
                initAssets = (initAssets - initAssets * 6 / 100) * (1 + rate);
            }

            Set<Map.Entry<Integer, Double>> entries = everyYearsRebate.entrySet();
            for (Map.Entry<Integer, Double> entry : entries) {
                sb.append("第" + (entry.getKey() + 1) + "年返利" + entry.getValue() + "元" + "<br/>");
            }
            sb.append(n + "年后资产总额价值" + initAssets + "元" + "<br/>");
            return sb.toString();
        } catch (Exception e) {
            return "不好意思，您输入错误，请重新输入投资金额，投资年限和您期望的年利率";
        }
    }

    @GetMapping(value = "getAssetsAndGetMoney/text")
    public String getAssetsAndGetMoney(@RequestParam Double initAssets, @RequestParam Double rate, @RequestParam Integer n) {
        Map<Integer, Double> everyYearsRebate = new HashMap<Integer, Double>();
        if (initAssets <= 0 || n <= 0 || rate <= 0.0) {
            return "不好意思，您输入错误，请重新输入投资金额，投资年限和您期望的年利率";
        }

        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < n; i++) {
                everyYearsRebate.put(i, initAssets * 6 / 100);
                initAssets = (initAssets - initAssets * 6 / 100) * (1 + rate);
            }

            Set<Map.Entry<Integer, Double>> entries = everyYearsRebate.entrySet();
            for (Map.Entry<Integer, Double> entry : entries) {
                sb.append("第" + (entry.getKey() + 1) + "年返利" + entry.getValue() + "元 " + "<br/>");
            }
            sb.append(n + "年后资产总额价值" + initAssets + "元 " + "<br/>");
            return sb.toString();
        } catch (Exception e) {
            return "不好意思，您输入错误，请重新输入投资金额，投资年限和您期望的年利率";
        }
    }


    @GetMapping(value = "getAssetsButNoGetMoney")
    public String getAssetsButNoGetMoney(@RequestBody AssertDTO assertDTO) {
        if (assertDTO == null || assertDTO.getInitAssert() <= 0 || assertDTO.getYears() <= 0 || assertDTO.getRate() <= 0.0) {
            return "不好意思，您输入错误，请重新输入投资金额，投资年限和您期望的年利率";
        }

        StringBuilder sb = new StringBuilder();

        Double initAssets = assertDTO.getInitAssert();
        Integer n = assertDTO.getYears();
        Double rate = assertDTO.getRate();

        try {
            for (int i = 0; i < n; i++) {
                initAssets = (initAssets) * (1 + rate);
                sb.append("第" + (i + 1) + "年资产总额" + initAssets + "元" + "<br/>");
            }
            sb.append(n + "年后资产总额价值" + initAssets + "元" + "<br/>");
            return sb.toString();
        } catch (Exception e) {
            return "不好意思，您输入错误，请重新输入投资金额，投资年限和您期望的年利率";
        }
    }
}

