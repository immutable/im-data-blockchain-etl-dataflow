package io.blockchainetl.ethereum.domain;

import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@DefaultCoder(AvroCoder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contract {

    @Nullable
    private String type;

    @Nullable
    private String address;

    @Nullable
    @JsonProperty("chain_id")
    private Long chainId;

    @Nullable
    private String bytecode;

    @Nullable
    @JsonProperty("function_sighashes")
    private List<String> functionSighashes;

    @Nullable
    @JsonProperty("is_erc20")
    private Boolean isErc20;

    @Nullable
    @JsonProperty("is_erc721")
    private Boolean isErc721;

    @Nullable
    @JsonProperty("is_erc1155")
    private Boolean isErc1155;

    @Nullable
    @JsonProperty("proxy_type")
    private String proxyType;

    @Nullable
    @JsonProperty("implementation_address")
    private String implementationAddress;

    @Nullable
    @JsonProperty("block_timestamp")
    private Long blockTimestamp;

    @Nullable
    @JsonProperty("block_number")
    private Long blockNumber;

    @Nullable
    @JsonProperty("block_hash")
    private String blockHash;
    
    public Contract() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public String getBytecode() {
        return bytecode;
    }

    public void setBytecode(String bytecode) {
        this.bytecode = bytecode;
    }

    public List<String> getFunctionSighashes() {
        return functionSighashes;
    }

    public void setFunctionSighashes(List<String> functionSighashes) {
        this.functionSighashes = functionSighashes;
    }

    public Boolean getErc20() {
        return isErc20;
    }

    public void setErc20(Boolean erc20) {
        this.isErc20 = erc20;
    }

    public Boolean getErc721() {
        return isErc721;
    }

    public void setErc721(Boolean erc721) {
        this.isErc721 = erc721;
    }

    public Boolean getErc1155() {
        return isErc1155;
    }

    public void setErc1155(Boolean erc1155) {
        this.isErc1155 = erc1155;
    }

    public String getProxyType() {
        return proxyType;
    }

    public void setProxyType(String proxyType) {
        this.proxyType = proxyType;
    }

    public String getImplementationAddress() {
        return implementationAddress;
    }

    public void setImplementationAddress(String implementationAddress) {
        this.implementationAddress = implementationAddress;
    }

    public Long getBlockTimestamp() {
        return blockTimestamp;
    }

    public void setBlockTimestamp(Long blockTimestamp) {
        this.blockTimestamp = blockTimestamp;
    }

    public Long getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Long blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contract contract = (Contract) o;
        return Objects.equal(type, contract.type) &&
            Objects.equal(address, contract.address) &&
            Objects.equal(chainId, contract.chainId) &&
            Objects.equal(bytecode, contract.bytecode) &&
            Objects.equal(functionSighashes, contract.functionSighashes) &&
            Objects.equal(isErc20, contract.isErc20) &&
            Objects.equal(isErc721, contract.isErc721) &&
            Objects.equal(isErc1155, contract.isErc1155) &&
            Objects.equal(proxyType, contract.proxyType) &&
            Objects.equal(implementationAddress, contract.implementationAddress) &&
            Objects.equal(blockTimestamp, contract.blockTimestamp) &&
            Objects.equal(blockNumber, contract.blockNumber) &&
            Objects.equal(blockHash, contract.blockHash);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, address, chainId, bytecode, functionSighashes, isErc20, isErc721, isErc1155,
            proxyType, implementationAddress, blockTimestamp, blockNumber, blockHash);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("type", type)
            .add("address", address)
            .add("chainId", chainId)
            .add("bytecode", bytecode)
            .add("functionSighashes", functionSighashes)
            .add("isErc20", isErc20)
            .add("isErc721", isErc721)
            .add("isErc1155", isErc1155)
            .add("proxyType", proxyType)
            .add("implementationAddress", implementationAddress)
            .add("blockTimestamp", blockTimestamp)
            .add("blockNumber", blockNumber)
            .add("blockHash", blockHash)
            .toString();
    }
}
