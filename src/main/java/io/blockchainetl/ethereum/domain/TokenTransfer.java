package io.blockchainetl.ethereum.domain;

import com.google.common.base.Objects;
import com.google.common.base.MoreObjects;
import org.apache.avro.reflect.Nullable;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigInteger;

@DefaultCoder(AvroCoder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenTransfer {

    @Nullable
    @JsonProperty("token_address")
    private String tokenAddress;
    
    @Nullable
    @JsonProperty("from_address")
    private String fromAddress;

    @Nullable
    @JsonProperty("to_address")
    private String toAddress;

    @Nullable
    private BigInteger value;

    @Nullable
    @JsonProperty("transaction_hash")
    private String transactionHash;

    @Nullable
    @JsonProperty("log_index")
    private Long logIndex;

    @Nullable
    @JsonProperty("block_timestamp")
    private Long blockTimestamp;

    @Nullable
    @JsonProperty("block_number")
    private Long blockNumber;

    @Nullable
    @JsonProperty("block_hash")
    private String blockHash;

    @Nullable
    @JsonProperty("chain_id")
    private Long chainId;
    
    public TokenTransfer() {}

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public Long getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(Long logIndex) {
        this.logIndex = logIndex;
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

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenTransfer that = (TokenTransfer) o;
        return Objects.equal(tokenAddress, that.tokenAddress) &&
            Objects.equal(fromAddress, that.fromAddress) &&
            Objects.equal(toAddress, that.toAddress) &&
            Objects.equal(value, that.value) &&
            Objects.equal(transactionHash, that.transactionHash) &&
            Objects.equal(logIndex, that.logIndex) &&
            Objects.equal(blockTimestamp, that.blockTimestamp) &&
            Objects.equal(blockNumber, that.blockNumber) &&
            Objects.equal(blockHash, that.blockHash) &&
            Objects.equal(chainId, that.chainId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tokenAddress, fromAddress, toAddress, value, transactionHash, logIndex, blockTimestamp,
            blockNumber, blockHash, chainId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("tokenAddress", tokenAddress)
            .add("fromAddress", fromAddress)
            .add("toAddress", toAddress)
            .add("value", value)
            .add("transactionHash", transactionHash)
            .add("logIndex", logIndex)
            .add("blockTimestamp", blockTimestamp)
            .add("blockNumber", blockNumber)
            .add("blockHash", blockHash)
            .add("chainId", chainId)
            .toString();
    }
}
