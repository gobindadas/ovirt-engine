package org.ovirt.engine.core.common.action;

import org.ovirt.engine.core.compat.Guid;

public class TransferDiskImageParameters extends TransferImageParameters {
    private static final long serialVersionUID = -1534535133135826714L;
    private AddDiskParameters addDiskParameters;

    public TransferDiskImageParameters() {}

    public TransferDiskImageParameters(Guid storageDomainId, int keepaliveInterval, AddDiskParameters addDiskParameters) {
        super(storageDomainId, keepaliveInterval);
        this.addDiskParameters = addDiskParameters;
    }

    public AddDiskParameters getAddDiskParameters() {
        return addDiskParameters;
    }

    public void setAddDiskParameters(AddDiskParameters addDiskParameters) {
        this.addDiskParameters = addDiskParameters;
    }
}
