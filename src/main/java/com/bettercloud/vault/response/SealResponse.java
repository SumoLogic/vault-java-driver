package com.bettercloud.vault.response;

import com.bettercloud.vault.json.*;
import com.bettercloud.vault.rest.RestResponse;

import java.io.UnsupportedEncodingException;

/**
 * This class is a container for the information returned by Vault in <code>v1/sys/*seal*</code>
 * operations.
 */
public class SealResponse extends VaultResponse {
    private Boolean sealed;
    private Long t;
    private Long n;
    private Long progress;

    /**
     * This constructor simply exposes the common base class constructor.
     *
     * @param restResponse The raw HTTP response from Vault.
     * @param retries      The number of retry attempts that occurred during the API call (can be zero).
     */
    public SealResponse(final RestResponse restResponse, final int retries) {
        super(restResponse, retries);

        try {
            final String responseJson = new String(restResponse.getBody(), "UTF-8");
            final JsonObject jsonObject = Json.parse(responseJson).asObject();

            sealed = jsonObject.getBoolean("sealed", false);
            t = jsonObject.getLong("t", 0);
            n = jsonObject.getLong("n", 0);
            progress = jsonObject.getLong("progress", 0);

        } catch (UnsupportedEncodingException | ParseException e) {
        }
    }

    public Boolean getSealed() {
        return sealed;
    }

    public Long getT() {
        return t;
    }

    public Long getN() {
        return n;
    }

    public Long getProgress() {
        return progress;
    }
}
