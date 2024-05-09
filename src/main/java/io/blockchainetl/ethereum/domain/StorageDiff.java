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
public class StorageDiff {

    @Nullable
    @JsonProperty("address")
    private String address;
    
    @Nullable
    @JsonProperty("slot")
    private String slot;

    @Nullable
    @JsonProperty("from_value")
    private String fromValue;

    @Nullable
    @JsonProperty("to_value")
    private String toValue;

    @Nullable
    @JsonProperty("transaction_hash")
    private String transactionHash;

    @Nullable
    @JsonProperty("transaction_index")
    private Long transactionIndex;

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
    
    public StorageDiff() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getFromValue() {
        return fromValue;
    }

    public void setFromValue(String fromValue) {
        this.fromValue = fromValue;
    }

    public String getToValue() {
        return toValue;
    }

    public void setToValue(String toValue) {
        this.toValue = toValue;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public Long getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(Long transactionIndex) {
        this.transactionIndex = transactionIndex;
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
        StorageDiff that = (StorageDiff) o;
        return Objects.equal(address, that.address) &&
            Objects.equal(slot, that.slot) &&
            Objects.equal(fromValue, that.fromValue) &&
            Objects.equal(toValue, that.toValue) &&
            Objects.equal(transactionHash, that.transactionHash) &&
            Objects.equal(transactionIndex, that.transactionIndex) &&
            Objects.equal(blockTimestamp, that.blockTimestamp) &&
            Objects.equal(blockNumber, that.blockNumber) &&
            Objects.equal(blockHash, that.blockHash) &&
            Objects.equal(chainId, that.chainId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(address, slot, fromValue, toValue, transactionHash, transactionIndex, blockTimestamp,
            blockNumber, blockHash, chainId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("address", address)
            .add("slot", slot)
            .add("fromValue", fromValue)
            .add("toValue", toValue)
            .add("transactionHash", transactionHash)
            .add("transactionIndex", transactionIndex)
            .add("blockTimestamp", blockTimestamp)
            .add("blockNumber", blockNumber)
            .add("blockHash", blockHash)
            .add("chainId", chainId)
            .toString();
    }
}
