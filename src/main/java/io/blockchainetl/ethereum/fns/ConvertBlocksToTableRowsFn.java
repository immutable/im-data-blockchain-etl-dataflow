package io.blockchainetl.ethereum.fns;

import com.google.api.services.bigquery.model.TableRow;
import io.blockchainetl.ethereum.domain.Block;
import io.blockchainetl.ethereum.domain.Withdrawal;
import io.blockchainetl.common.utils.JsonUtils;
import io.blockchainetl.common.fns.ConvertEntitiesToTableRowsFn;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class ConvertBlocksToTableRowsFn extends ConvertEntitiesToTableRowsFn {


    @Override
    protected void populateTableRowFields(TableRow row, String element) {
        Block block = JsonUtils.parseJson(element, Block.class);

        row.set("number", block.getNumber());
        row.set("chain_id", block.getChainId2());
        row.set("hash", block.getHash());
        row.set("parent_hash", block.getParentHash());
        row.set("nonce", block.getNonce());
        row.set("sha3_uncles", block.getSha3Uncles());
        row.set("nonce", block.getNonce());
        row.set("sha3_uncles", block.getSha3Uncles());
        row.set("logs_bloom", block.getLogsBloom());
        row.set("transactions_root", block.getTransactionsRoot());
        row.set("state_root", block.getStateRoot());
        row.set("receipts_root", block.getReceiptsRoot());
        row.set("miner", block.getMiner());
        row.set("difficulty", block.getDifficulty());
        row.set("total_difficulty", block.getTotalDifficulty());
        row.set("size", block.getSize());
        row.set("extra_data", block.getExtraData());
        row.set("gas_limit", block.getGasLimit());
        row.set("gas_used", block.getGasUsed());
        row.set("transaction_count", block.getTransactionCount());
        row.set("base_fee_per_gas", block.getBaseFeePerGas());
        row.set("withdrawals_root", block.getWithdrawalsRoot());
        row.set("withdrawals", convertWithdrawalsToTableRows(block.getWithdrawals()));
    }

    private TableRow[] convertWithdrawalsToTableRows(Withdrawal[] withdrawals) {
        if (withdrawals == null) {
            return null;
        }

        TableRow[] rows = new TableRow[withdrawals.length];
        for (int i = 0; i < withdrawals.length; i++) {
            Withdrawal withdrawal = withdrawals[i];
            TableRow row = new TableRow();
            row.set("index", withdrawal.getIndex());
            row.set("validator_index", withdrawal.getValidatorIndex());
            row.set("address", withdrawal.getAddress());
            row.set("amount", withdrawal.getAmount());
            rows[i] = row;
        }
        return rows;
    }
}
