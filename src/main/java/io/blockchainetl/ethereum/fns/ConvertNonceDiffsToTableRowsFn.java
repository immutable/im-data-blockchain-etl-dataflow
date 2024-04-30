package io.blockchainetl.ethereum.fns;

import com.google.api.services.bigquery.model.TableRow;
import io.blockchainetl.common.fns.ConvertEntitiesToTableRowsFn;
import io.blockchainetl.common.utils.JsonUtils;
import io.blockchainetl.ethereum.domain.NonceDiff;

public class ConvertNonceDiffsToTableRowsFn extends ConvertEntitiesToTableRowsFn {

    public ConvertNonceDiffsToTableRowsFn(String startTimestamp, Long allowedTimestampSkewSeconds) {
        super(startTimestamp, allowedTimestampSkewSeconds, "", false);
    }

    public ConvertNonceDiffsToTableRowsFn(String startTimestamp, Long allowedTimestampSkewSeconds, String logPrefix) {
        super(startTimestamp, allowedTimestampSkewSeconds, logPrefix, false);
    }

    @Override
    protected void populateTableRowFields(TableRow row, String element) {
        NonceDiff nonceDiff = JsonUtils.parseJson(element, NonceDiff.class);

        row.set("address", nonceDiff.getAddress());
        row.set("from_value", nonceDiff.getFromValue());
        row.set("to_value", nonceDiff.getToValue());
        row.set("transaction_hash", nonceDiff.getTransactionHash());
        row.set("transaction_index", nonceDiff.getTransactionIndex());
        row.set("block_number", nonceDiff.getBlockNumber());
        row.set("block_hash", nonceDiff.getBlockHash());
        row.set("chain_id", nonceDiff.getChainId());
    }
}
