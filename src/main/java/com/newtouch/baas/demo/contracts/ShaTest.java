package com.newtouch.baas.demo.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.DynamicBytes;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version null.
 */
@SuppressWarnings("unchecked")
public class ShaTest extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040526040805190810160405280600e81526020017f48656c6c6f2c20536861546573740000000000000000000000000000000000008152506000908051906020019061004f929190610062565b5034801561005c57600080fd5b50610107565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100a357805160ff19168380011785556100d1565b828001600101855582156100d1579182015b828111156100d05782518255916020019190600101906100b5565b5b5090506100de91906100e2565b5090565b61010491905b808211156101005760008160009055506001016100e8565b5090565b90565b6103db806101166000396000f300608060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633bc5de301461005c5780638b053758146100ec57806393730bbe14610171575b600080fd5b34801561006857600080fd5b506100716101f6565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100b1578082015181840152602081019050610096565b50505050905090810190601f1680156100de5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156100f857600080fd5b50610153600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610298565b60405180826000191660001916815260200191505060405180910390f35b34801561017d57600080fd5b506101d8600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610343565b60405180826000191660001916815260200191505060405180910390f35b606060008054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561028e5780601f106102635761010080835404028352916020019161028e565b820191906000526020600020905b81548152906001019060200180831161027157829003601f168201915b5050505050905090565b60006002826040518082805190602001908083835b6020831015156102d257805182526020820191506020810190506020830392506102ad565b6001836020036101000a0380198251168184511680821785525050505050509050019150506020604051808303816000865af1158015610316573d6000803e3d6000fd5b5050506040513d602081101561032b57600080fd5b81019080805190602001909291905050509050919050565b6000816040518082805190602001908083835b60208310151561037b5780518252602082019150602081019050602083039250610356565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902090509190505600a165627a7a72305820ea6f92d96d0d58fd872bf075817e7c97977d9d48a3ac6281e965d9fa1666d6840029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"getData\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"view\"},{\"constant\":false,\"inputs\":[{\"name\":\"_memory\",\"type\":\"bytes\",\"type0\":null,\"indexed\":false}],\"name\":\"getSha256\",\"outputs\":[{\"name\":\"result\",\"type\":\"bytes32\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[{\"name\":\"_memory\",\"type\":\"bytes\",\"type0\":null,\"indexed\":false}],\"name\":\"getKeccak256\",\"outputs\":[{\"name\":\"result\",\"type\":\"bytes32\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETDATA = "getData";

    public static final String FUNC_GETSHA256 = "getSha256";

    public static final String FUNC_GETKECCAK256 = "getKeccak256";

    @Deprecated
    protected ShaTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ShaTest(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ShaTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ShaTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static String getBinary() {
        return BINARY;
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<byte[]> getData() {
        final Function function = new Function(FUNC_GETDATA,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> getSha256(byte[] _memory) {
        final Function function = new Function(
                FUNC_GETSHA256,
                Arrays.<Type>asList(new DynamicBytes(_memory)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getSha256(byte[] _memory, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETSHA256,
                Arrays.<Type>asList(new DynamicBytes(_memory)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getSha256Seq(byte[] _memory) {
        final Function function = new Function(
                FUNC_GETSHA256,
                Arrays.<Type>asList(new DynamicBytes(_memory)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<byte[]> getGetSha256Input(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETSHA256,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public Tuple1<byte[]> getGetSha256Output(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GETSHA256,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> getKeccak256(byte[] _memory) {
        final Function function = new Function(
                FUNC_GETKECCAK256,
                Arrays.<Type>asList(new DynamicBytes(_memory)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getKeccak256(byte[] _memory, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETKECCAK256,
                Arrays.<Type>asList(new DynamicBytes(_memory)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getKeccak256Seq(byte[] _memory) {
        final Function function = new Function(
                FUNC_GETKECCAK256,
                Arrays.<Type>asList(new DynamicBytes(_memory)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<byte[]> getGetKeccak256Input(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETKECCAK256,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public Tuple1<byte[]> getGetKeccak256Output(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GETKECCAK256,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    @Deprecated
    public static ShaTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ShaTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ShaTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ShaTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ShaTest load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ShaTest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ShaTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ShaTest(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ShaTest> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ShaTest.class, web3j, credentials, contractGasProvider, getBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ShaTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ShaTest.class, web3j, credentials, gasPrice, gasLimit, getBinary(), "");
    }

    public static RemoteCall<ShaTest> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ShaTest.class, web3j, transactionManager, contractGasProvider, getBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ShaTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ShaTest.class, web3j, transactionManager, gasPrice, gasLimit, getBinary(), "");
    }
}
