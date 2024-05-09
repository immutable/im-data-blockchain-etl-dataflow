package io.blockchainetl.ethereum.fns;

import com.google.api.services.bigquery.model.TableRow;
import io.blockchainetl.common.fns.ConvertEntitiesToTableRowsFn;
import io.blockchainetl.common.utils.JsonUtils;
import io.blockchainetl.ethereum.domain.StorageDiff;

public class ConvertStorageDiffsToTableRowsFn extends ConvertEntitiesToTableRowsFn {

    public ConvertStorageDiffsToTableRowsFn(String startTimestamp, Long allowedTimestampSkewSeconds) {
        super(startTimestamp, allowedTimestampSkewSeconds, "", false);
    }

    public ConvertStorageDiffsToTableRowsFn(String startTimestamp, Long allowedTimestampSkewSeconds, String logPrefix) {
        super(startTimestamp, allowedTimestampSkewSeconds, logPrefix, false);
    }

    @Override
    protected void populateTableRowFields(TableRow row, String element) {
        StorageDiff storageDiff = JsonUtils.parseJson(element, StorageDiff.class);

        row.set("address", storageDiff.getAddress());
        row.set("slot", storageDiff.getSlot());
        row.set("from_value", storageDiff.getFromValue());
        row.set("to_value", storageDiff.getToValue());
        row.set("transaction_hash", storageDiff.getTransactionHash());
        row.set("transaction_index", storageDiff.getTransactionIndex());
        row.set("block_number", storageDiff.getBlockNumber());
        row.set("block_hash", storageDiff.getBlockHash());
        row.set("chain_id", storageDiff.getChainId());
    }
}
