package com.newtouch.baas.demo;

import com.newtouch.baas.demo.constants.GasConstants;
import com.newtouch.baas.demo.contracts.HelloWorld;
import com.newtouch.baas.demo.contracts.ShaTest;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Web3j web3j;
    @Autowired private Credentials credentials;

    @Test
    void contextLoads() throws Exception {  // deploy contract

        BigInteger blockNumber = web3j.getBlockNumber().send().getBlockNumber();
        assertTrue(blockNumber.compareTo(new BigInteger("0")) >= 0);

        HelloWorld helloWorld =
                HelloWorld.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                        .send();
        if (helloWorld != null) {
            System.out.println("HelloWorld address is: " + helloWorld.getContractAddress());
            // call set function
            helloWorld.set("Hello, World!").send();
            // call get function
            String result = helloWorld.get().send();
            System.out.println(result);
            assertTrue("Hello, World!".equals(result));
        }


        ShaTest shaTest = ShaTest.deploy(  web3j,
                credentials,
                new StaticGasProvider(
                        GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                .send();
        if(shaTest != null){
            TransactionReceipt result = shaTest.getSha256("123".getBytes()).send();
            System.out.println(result.getTransactionHash());
        }
    }

}
