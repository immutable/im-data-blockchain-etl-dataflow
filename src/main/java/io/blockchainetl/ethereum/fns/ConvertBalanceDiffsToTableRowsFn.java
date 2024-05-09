package io.blockchainetl.ethereum.fns;

import com.google.api.services.bigquery.model.TableRow;
import io.blockchainetl.common.fns.ConvertEntitiesToTableRowsFn;
import io.blockchainetl.common.utils.JsonUtils;
import io.blockchainetl.ethereum.domain.BalanceDiff;

public class ConvertBalanceDiffsToTableRowsFn extends ConvertEntitiesToTableRowsFn {

    public ConvertBalanceDiffsToTableRowsFn(String startTimestamp, Long allowedTimestampSkewSeconds) {
        super(startTimestamp, allowedTimestampSkewSeconds, "", false);
    }

    public ConvertBalanceDiffsToTableRowsFn(String startTimestamp, Long allowedTimestampSkewSeconds, String logPrefix) {
        super(startTimestamp, allowedTimestampSkewSeconds, logPrefix, false);
    }

    @Override
    protected void populateTableRowFields(TableRow row, String element) {
        BalanceDiff balanceDiff = JsonUtils.parseJson(element, BalanceDiff.class);

        row.set("address", balanceDiff.getAddress());
        row.set("from_value", balanceDiff.getFromValue());
        row.set("to_value", balanceDiff.getToValue());
        row.set("transaction_hash", balanceDiff.getTransactionHash());
        row.set("transaction_index", balanceDiff.getTransactionIndex());
        row.set("block_number", balanceDiff.getBlockNumber());
        row.set("block_hash", balanceDiff.getBlockHash());
        row.set("chain_id", balanceDiff.getChainId());
    }
}
