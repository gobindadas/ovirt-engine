package org.ovirt.engine.core.common.action;

import java.util.HashMap;

import org.ovirt.engine.core.common.businessentities.ActionGroup;

public enum VdcActionType {
    Unknown(0, QuotaDependency.NONE),
    // Vm Commands
    AddVm(1, ActionGroup.CREATE_VM, QuotaDependency.BOTH),
    AddVmFromTemplate(2, ActionGroup.CREATE_VM, QuotaDependency.BOTH),
    AddVmFromScratch(3, ActionGroup.CREATE_VM, QuotaDependency.BOTH),
    RemoveVm(4, ActionGroup.DELETE_VM, QuotaDependency.STORAGE),
    UpdateVm(5, ActionGroup.EDIT_VM_PROPERTIES, QuotaDependency.VDS_GROUP),
    RebootVm(6, ActionGroup.REBOOT_VM, QuotaDependency.NONE),
    StopVm(7, ActionGroup.STOP_VM, QuotaDependency.BOTH),
    ShutdownVm(8, ActionGroup.SHUT_DOWN_VM, QuotaDependency.VDS_GROUP),
    ChangeDisk(9, ActionGroup.CHANGE_VM_CD, QuotaDependency.NONE),
    PauseVm(10, QuotaDependency.NONE),
    HibernateVm(11, ActionGroup.HIBERNATE_VM, QuotaDependency.NONE),
    RunVm(12, ActionGroup.RUN_VM, QuotaDependency.VDS_GROUP),
    RunVmOnce(13, ActionGroup.RUN_VM, QuotaDependency.BOTH),
    MigrateVm(14, ActionGroup.MIGRATE_VM, QuotaDependency.NONE),
    InternalMigrateVm(15, QuotaDependency.NONE),
    MigrateVmToServer(16, ActionGroup.MIGRATE_VM, QuotaDependency.NONE),
    ReorderVmNics(17, ActionGroup.CREATE_VM, false, QuotaDependency.NONE),
    VmLogon(18, ActionGroup.CONNECT_TO_VM, QuotaDependency.NONE),
    SetVmTicket(22, ActionGroup.CONNECT_TO_VM, false, QuotaDependency.NONE),
    ExportVm(23, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.NONE),
    ExportVmTemplate(24, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.NONE),
    RestoreStatelessVm(25, QuotaDependency.NONE),
    AddVmInterface(28, ActionGroup.CONFIGURE_VM_NETWORK, false, QuotaDependency.NONE),
    RemoveVmInterface(29, ActionGroup.CONFIGURE_VM_NETWORK, false, QuotaDependency.NONE),
    UpdateVmInterface(30, ActionGroup.CONFIGURE_VM_NETWORK, false, QuotaDependency.NONE),
    AddDisk(31, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.STORAGE),
    RegisterDisk(32, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.STORAGE),
    @Deprecated
    MoveVm(33, ActionGroup.MOVE_VM, QuotaDependency.NONE),
    UpdateVmDisk(34, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    AttachDiskToVm(180, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.NONE),
    DetachDiskFromVm(181, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.NONE),
    HotPlugDiskToVm(182, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.NONE),
    HotUnPlugDiskFromVm(183, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.NONE),
    HotSetNumberOfCpus(184, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.VDS_GROUP, true),
    VmSlaPolicy(185, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),
    HotSetAmountOfMemory(186, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.VDS_GROUP, true),
    ChangeFloppy(35, QuotaDependency.NONE),
    ImportVm(36, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.STORAGE),
    RemoveVmFromImportExport(37, ActionGroup.DELETE_VM, QuotaDependency.NONE),
    RemoveVmTemplateFromImportExport(38, ActionGroup.DELETE_TEMPLATE, QuotaDependency.NONE),
    ImportVmTemplate(39, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.STORAGE),
    ChangeVMCluster(40, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),
    CancelMigrateVm(41, ActionGroup.MIGRATE_VM, false, QuotaDependency.NONE),
    ActivateDeactivateVmNic(42, QuotaDependency.NONE),
    AddVmFromSnapshot(52, ActionGroup.CREATE_VM, QuotaDependency.BOTH),
    CloneVm(53, ActionGroup.CREATE_VM, QuotaDependency.BOTH),
    ImportVmFromConfiguration(43, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.STORAGE),
    UpdateVmVersion(44, QuotaDependency.NONE),
    ImportVmTemplateFromConfiguration(45, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.STORAGE),
    ProcessDownVm(46, QuotaDependency.NONE),
    ConvertVm(47, QuotaDependency.NONE),
    ImportVmFromExternalProvider(48, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.STORAGE),
    ImportVmFromOva(49, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.STORAGE),
    ConvertOva(50, QuotaDependency.NONE),
    CancelConvertVm(51, ActionGroup.IMPORT_EXPORT_VM, QuotaDependency.NONE),
    // VdsCommands
    AddVds(101, ActionGroup.CREATE_HOST, QuotaDependency.NONE),
    UpdateVds(102, ActionGroup.EDIT_HOST_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveVds(103, ActionGroup.DELETE_HOST, false, QuotaDependency.NONE),
    RestartVds(104, ActionGroup.MANIPULATE_HOST, QuotaDependency.NONE),
    VdsNotRespondingTreatment(105, QuotaDependency.NONE),
    MaintenanceVds(106, QuotaDependency.NONE),
    MaintenanceNumberOfVdss(107, ActionGroup.MANIPULATE_HOST, false, QuotaDependency.NONE),
    ActivateVds(108, ActionGroup.MANIPULATE_HOST, QuotaDependency.NONE),
    InstallVdsInternal(109, QuotaDependency.NONE),
    ClearNonResponsiveVdsVms(110, QuotaDependency.NONE),
    ApproveVds(112, ActionGroup.CREATE_HOST, QuotaDependency.NONE),
    HandleVdsCpuFlagsOrClusterChanged(114, QuotaDependency.NONE),
    InitVdsOnUp(115, QuotaDependency.NONE),
    SetNonOperationalVds(117, QuotaDependency.NONE),
    AddVdsSpmId(119, QuotaDependency.NONE),
    ForceSelectSPM(120, QuotaDependency.NONE),
    // Fencing (including RestartVds above)
    StartVds(121, ActionGroup.MANIPULATE_HOST, QuotaDependency.NONE),
    StopVds(122, ActionGroup.MANIPULATE_HOST, QuotaDependency.NONE),
    HandleVdsVersion(124, QuotaDependency.NONE),
    ChangeVDSCluster(125, ActionGroup.EDIT_HOST_CONFIGURATION, false, QuotaDependency.NONE),
    RefreshHostCapabilities(126, ActionGroup.MANIPULATE_HOST, false, QuotaDependency.NONE),
    SshSoftFencing(127, QuotaDependency.NONE),
    VdsPowerDown(128, ActionGroup.MANIPULATE_HOST, QuotaDependency.NONE),
    UpgradeOvirtNodeInternal(129, QuotaDependency.NONE),
    InstallVds(130, ActionGroup.EDIT_HOST_CONFIGURATION, false, QuotaDependency.NONE),
    UpgradeOvirtNode(131, ActionGroup.EDIT_HOST_CONFIGURATION, false, QuotaDependency.NONE),
    VdsKdumpDetection(132, QuotaDependency.NONE),
    AddFenceAgent(133, ActionGroup.EDIT_HOST_CONFIGURATION, QuotaDependency.NONE),
    RemoveFenceAgent(134, ActionGroup.EDIT_HOST_CONFIGURATION, QuotaDependency.NONE),
    UpdateFenceAgent(135, ActionGroup.EDIT_HOST_CONFIGURATION, QuotaDependency.NONE),
    RemoveFenceAgentsByVdsId(136, ActionGroup.EDIT_HOST_CONFIGURATION, QuotaDependency.NONE),
    UpgradeHost(137, ActionGroup.EDIT_HOST_CONFIGURATION, false, QuotaDependency.NONE),
    UpgradeHostInternal(138, QuotaDependency.NONE),
    HostEnrollCertificate(139, ActionGroup.EDIT_HOST_CONFIGURATION, false, QuotaDependency.NONE),
    HostEnrollCertificateInternal(140, QuotaDependency.NONE),

    // Network
    UpdateNetworkToVdsInterface(149, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    AttachNetworkToVdsInterface(150, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    DetachNetworkFromVdsInterface(151, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    AddBond(152, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    RemoveBond(153, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    AddNetwork(154, ActionGroup.CREATE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    RemoveNetwork(155, ActionGroup.CONFIGURE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    UpdateNetwork(156, ActionGroup.CONFIGURE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    CommitNetworkChanges(157, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),

    @Deprecated
    SetupNetworks(158, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),

    // VnicProfile Commands
    AddVnicProfile(160, ActionGroup.CREATE_NETWORK_VNIC_PROFILE, false, QuotaDependency.NONE),
    UpdateVnicProfile(161, ActionGroup.CONFIGURE_NETWORK_VNIC_PROFILE, false, QuotaDependency.NONE),
    RemoveVnicProfile(162, ActionGroup.DELETE_NETWORK_VNIC_PROFILE, false, QuotaDependency.NONE),

    // Network labels
    LabelNetwork(163, ActionGroup.CONFIGURE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    UnlabelNetwork(164, ActionGroup.CONFIGURE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    LabelNic(165, ActionGroup.CONFIGURE_HOST_NETWORK, false, QuotaDependency.NONE),
    UnlabelNic(166, ActionGroup.CONFIGURE_HOST_NETWORK, false, QuotaDependency.NONE),
    PropagateLabeledNetworksToClusterHosts(167, false, QuotaDependency.NONE),

    // SR-IOV
    UpdateHostNicVfsConfig(175, ActionGroup.CONFIGURE_HOST_NETWORK, false, QuotaDependency.NONE),
    AddVfsConfigNetwork(168, ActionGroup.CONFIGURE_HOST_NETWORK, false, QuotaDependency.NONE),
    RemoveVfsConfigNetwork(169, ActionGroup.CONFIGURE_HOST_NETWORK, false, QuotaDependency.NONE),
    AddVfsConfigLabel(173, ActionGroup.CONFIGURE_HOST_NETWORK, false, QuotaDependency.NONE),
    RemoveVfsConfigLabel(174, ActionGroup.CONFIGURE_HOST_NETWORK, false, QuotaDependency.NONE),

    // NUMA
    AddVmNumaNodes(170, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),
    UpdateVmNumaNodes(171, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),
    RemoveVmNumaNodes(172, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),
    SetVmNumaNodes(176, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),

    // VmTemplatesCommand
    AddVmTemplate(201, ActionGroup.CREATE_TEMPLATE, QuotaDependency.BOTH),
    UpdateVmTemplate(202, ActionGroup.EDIT_TEMPLATE_PROPERTIES, QuotaDependency.VDS_GROUP),
    RemoveVmTemplate(203, ActionGroup.DELETE_TEMPLATE, QuotaDependency.STORAGE),
    MoveOrCopyTemplate(226, ActionGroup.COPY_TEMPLATE, QuotaDependency.STORAGE),
    AddVmTemplateInterface(220, ActionGroup.CONFIGURE_TEMPLATE_NETWORK, false, QuotaDependency.NONE),
    RemoveVmTemplateInterface(221, ActionGroup.CONFIGURE_TEMPLATE_NETWORK, false, QuotaDependency.NONE),
    UpdateVmTemplateInterface(222, ActionGroup.CONFIGURE_TEMPLATE_NETWORK, false, QuotaDependency.NONE),
    AddVmTemplateFromSnapshot(240, ActionGroup.CREATE_TEMPLATE, QuotaDependency.BOTH),
    // ImagesCommands
    TryBackToSnapshot(204, QuotaDependency.NONE),
    RestoreFromSnapshot(205, QuotaDependency.STORAGE),
    CreateAllSnapshotsFromVm(206, ActionGroup.MANIPULATE_VM_SNAPSHOTS, QuotaDependency.STORAGE),
    CreateSnapshot(207, QuotaDependency.STORAGE),
    CreateSnapshotFromTemplate(208, QuotaDependency.STORAGE),
    CreateImageTemplate(209, QuotaDependency.STORAGE),
    RemoveSnapshot(210, ActionGroup.MANIPULATE_VM_SNAPSHOTS, QuotaDependency.STORAGE),
    RemoveImage(211, QuotaDependency.STORAGE),
    RemoveAllVmImages(212, QuotaDependency.STORAGE),
    AddImageFromScratch(213, QuotaDependency.STORAGE),
    RemoveTemplateSnapshot(215, QuotaDependency.STORAGE),
    RemoveAllVmTemplateImageTemplates(216, QuotaDependency.STORAGE),
    TryBackToAllSnapshotsOfVm(223, ActionGroup.MANIPULATE_VM_SNAPSHOTS, QuotaDependency.NONE),
    RestoreAllSnapshots(224, ActionGroup.MANIPULATE_VM_SNAPSHOTS, QuotaDependency.STORAGE),
    CopyImageGroup(225, QuotaDependency.STORAGE),
    MoveOrCopyDisk(228, QuotaDependency.STORAGE),
    RemoveSnapshotSingleDisk(227, QuotaDependency.STORAGE),
    CreateCloneOfTemplate(229, QuotaDependency.STORAGE),
    RemoveDisk(230, QuotaDependency.STORAGE),
    MoveImageGroup(231, QuotaDependency.STORAGE),
    GetDiskAlignment(232, QuotaDependency.NONE),
    RemoveVmHibernationVolumes(233, QuotaDependency.NONE),
    RemoveMemoryVolumes(234, QuotaDependency.NONE),
    RemoveDiskSnapshots(235, ActionGroup.MANIPULATE_VM_SNAPSHOTS, QuotaDependency.NONE),
    RemoveSnapshotSingleDiskLive(236, QuotaDependency.STORAGE),
    Merge(237, QuotaDependency.STORAGE),
    MergeStatus(238, QuotaDependency.NONE),
    DestroyImage(239, QuotaDependency.STORAGE),
    MergeExtend(241, QuotaDependency.STORAGE),
    DestroyImageCheck(242, QuotaDependency.NONE),
    // VmPoolCommands
    AddVmPoolWithVms(304, ActionGroup.CREATE_VM_POOL, QuotaDependency.BOTH),
    UpdateVmPoolWithVms(305, ActionGroup.EDIT_VM_POOL_CONFIGURATION, QuotaDependency.STORAGE),
    AddVmAndAttachToPool(306, QuotaDependency.NONE),
    RemoveVmPool(307, ActionGroup.DELETE_VM_POOL, QuotaDependency.NONE),
    DetachUserFromVmFromPool(312, QuotaDependency.NONE),
    AddVmToPool(313, QuotaDependency.NONE),
    RemoveVmFromPool(314, ActionGroup.EDIT_VM_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    AttachUserToVmFromPoolAndRun(318, ActionGroup.VM_POOL_BASIC_OPERATIONS, QuotaDependency.VDS_GROUP),
    // UserAndGroupsCommands
    LoginUser(406, ActionGroup.LOGIN, false, QuotaDependency.NONE),
    LogoutSession(408, false, QuotaDependency.NONE),
    RemoveUser(409, ActionGroup.MANIPULATE_USERS, false, QuotaDependency.NONE),
    TerminateSession(410, false, QuotaDependency.NONE),
    RemoveGroup(415, ActionGroup.MANIPULATE_USERS, false, QuotaDependency.NONE),
    LoginAdminUser(418, ActionGroup.LOGIN, false, QuotaDependency.NONE),
    AddUser(419, ActionGroup.MANIPULATE_USERS, false, QuotaDependency.NONE),
    AddGroup(420, ActionGroup.MANIPULATE_USERS, false, QuotaDependency.NONE),
    LoginOnBehalf(424, false, QuotaDependency.NONE),
    // UserProfile
    AddUserProfile(421, ActionGroup.EDIT_PROFILE, false, QuotaDependency.NONE),
    UpdateUserProfile(422, ActionGroup.EDIT_PROFILE, false, QuotaDependency.NONE),
    RemoveUserProfile(423, ActionGroup.EDIT_PROFILE, false, QuotaDependency.NONE),
    // Tags
    AddTag(501, false, QuotaDependency.NONE),
    RemoveTag(502, false, QuotaDependency.NONE),
    UpdateTag(503, false, QuotaDependency.NONE),
    MoveTag(504, false, QuotaDependency.NONE),
    AttachUserToTag(505, false, QuotaDependency.NONE),
    DetachUserFromTag(506, false, QuotaDependency.NONE),
    AttachUserGroupToTag(507, false, QuotaDependency.NONE),
    DetachUserGroupFromTag(508, false, QuotaDependency.NONE),
    AttachVmsToTag(509, false, QuotaDependency.NONE),
    DetachVmFromTag(510, false, QuotaDependency.NONE),
    AttachVdsToTag(511, false, QuotaDependency.NONE),
    DetachVdsFromTag(512, false, QuotaDependency.NONE),
    UpdateTagsVmMapDefaultDisplayType(515, false, QuotaDependency.NONE),
    AttachTemplatesToTag(516, false, QuotaDependency.NONE),
    DetachTemplateFromTag(517, false, QuotaDependency.NONE),

    // Quota
    AddQuota(601, ActionGroup.CONFIGURE_QUOTA, false, QuotaDependency.NONE),
    UpdateQuota(602, ActionGroup.CONFIGURE_QUOTA, false, QuotaDependency.NONE),
    RemoveQuota(603, ActionGroup.CONFIGURE_QUOTA, false, QuotaDependency.NONE),
    ChangeQuotaForDisk(604, ActionGroup.CONSUME_QUOTA, false, QuotaDependency.STORAGE),

    // bookmarks
    AddBookmark(701, QuotaDependency.NONE),
    RemoveBookmark(702, QuotaDependency.NONE),
    UpdateBookmark(703, QuotaDependency.NONE),
    // vdsGroups
    AddVdsGroup(704, ActionGroup.CREATE_CLUSTER, false, QuotaDependency.NONE),
    UpdateVdsGroup(705, ActionGroup.EDIT_CLUSTER_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveVdsGroup(706, ActionGroup.DELETE_CLUSTER, false, QuotaDependency.NONE),
    AttachNetworkToClusterInternal(707, false, QuotaDependency.NONE),
    AttachNetworkToVdsGroup(708, ActionGroup.ASSIGN_CLUSTER_NETWORK, false, QuotaDependency.NONE),
    DetachNetworkToVdsGroup(709, ActionGroup.ASSIGN_CLUSTER_NETWORK, false, QuotaDependency.NONE),
    DetachNetworkFromClusterInternal(710, false, QuotaDependency.NONE),
    UpdateNetworkOnCluster(711, ActionGroup.CONFIGURE_CLUSTER_NETWORK, false, QuotaDependency.NONE),

    ManageNetworkClusters(712, ActionGroup.ASSIGN_CLUSTER_NETWORK, false, QuotaDependency.NONE),

    /**
     * MultiLevelAdministration
     */
    AddPermission(800, ActionGroup.MANIPULATE_PERMISSIONS, false, QuotaDependency.NONE),
    RemovePermission(801, ActionGroup.MANIPULATE_PERMISSIONS, false, QuotaDependency.NONE),
    UpdateRole(803, ActionGroup.MANIPULATE_ROLES, false, QuotaDependency.NONE),
    RemoveRole(804, ActionGroup.MANIPULATE_ROLES, false, QuotaDependency.NONE),
    AttachActionGroupsToRole(805, ActionGroup.MANIPULATE_ROLES, false, QuotaDependency.NONE),
    DetachActionGroupsFromRole(806, ActionGroup.MANIPULATE_ROLES, false, QuotaDependency.NONE),
    AddRoleWithActionGroups(809, ActionGroup.MANIPULATE_ROLES, false, QuotaDependency.NONE),
    AddSystemPermission(811, ActionGroup.MANIPULATE_PERMISSIONS, false, QuotaDependency.NONE),
    RemoveSystemPermission(812, ActionGroup.MANIPULATE_PERMISSIONS, false, QuotaDependency.NONE),

    /**
     * Storages handling
     */
    AddLocalStorageDomain(916, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    AddNFSStorageDomain(902, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    UpdateStorageDomain(903, ActionGroup.EDIT_STORAGE_DOMAIN_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveStorageDomain(904, ActionGroup.DELETE_STORAGE_DOMAIN, QuotaDependency.NONE),
    ForceRemoveStorageDomain(905, ActionGroup.DELETE_STORAGE_DOMAIN, QuotaDependency.NONE),
    AttachStorageDomainToPool(906, ActionGroup.MANIPULATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    DetachStorageDomainFromPool(907, ActionGroup.MANIPULATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    ActivateStorageDomain(908, ActionGroup.MANIPULATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    ConnectDomainToStorage(912, QuotaDependency.NONE),
    DeactivateStorageDomain(909, ActionGroup.MANIPULATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    AddSANStorageDomain(910, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    ExtendSANStorageDomain(911, ActionGroup.EDIT_STORAGE_DOMAIN_CONFIGURATION, QuotaDependency.NONE),
    ReconstructMasterDomain(913, QuotaDependency.NONE),
    DeactivateStorageDomainWithOvfUpdate(914, ActionGroup.MANIPULATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    RecoveryStoragePool(915, ActionGroup.CREATE_STORAGE_POOL, QuotaDependency.NONE),
    RefreshLunsSize(917, ActionGroup.EDIT_STORAGE_DOMAIN_CONFIGURATION, QuotaDependency.NONE),
    AddEmptyStoragePool(950, ActionGroup.CREATE_STORAGE_POOL, false, QuotaDependency.NONE),
    AddStoragePoolWithStorages(951, ActionGroup.CREATE_STORAGE_POOL, QuotaDependency.NONE),
    RemoveStoragePool(957, ActionGroup.DELETE_STORAGE_POOL, QuotaDependency.NONE),
    UpdateStoragePool(958, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, QuotaDependency.NONE),
    FenceVdsManualy(959, ActionGroup.MANIPULATE_HOST, false, QuotaDependency.NONE),
    AddExistingFileStorageDomain(960, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    AddExistingBlockStorageDomain(961, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    AddStorageServerConnection(1000, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    UpdateStorageServerConnection(1001, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    DisconnectStorageServerConnection(1002, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    RemoveStorageServerConnection(1003, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    ConnectHostToStoragePoolServers(1004, QuotaDependency.NONE),
    DisconnectHostFromStoragePoolServers(1005, QuotaDependency.NONE),
    ConnectStorageToVds(1006, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    SetStoragePoolStatus(1007, QuotaDependency.NONE),
    ConnectAllHostsToLun(1008, QuotaDependency.NONE),
    AddPosixFsStorageDomain(1009, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    LiveMigrateDisk(1010, QuotaDependency.NONE),
    LiveMigrateVmDisks(1011, false, QuotaDependency.STORAGE),
    MoveDisks(1012, false, QuotaDependency.NONE),
    ExtendImageSize(1013, false, QuotaDependency.STORAGE),
    ImportRepoImage(1014, ActionGroup.CREATE_DISK, QuotaDependency.STORAGE),
    ExportRepoImage(1015, QuotaDependency.NONE),
    AttachStorageConnectionToStorageDomain(1016, ActionGroup.MANIPULATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    DetachStorageConnectionFromStorageDomain(1017, ActionGroup.MANIPULATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    SyncLunsInfoForBlockStorageDomain(1018, false, QuotaDependency.NONE),
    UpdateStorageServerConnectionExtension(1019, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    RemoveStorageServerConnectionExtension(1020, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    AddStorageServerConnectionExtension(1021, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    RefreshVolume(1022, QuotaDependency.NONE),

    // Event Notification
    AddEventSubscription(1100, false, QuotaDependency.NONE),
    RemoveEventSubscription(1101, false, QuotaDependency.NONE),

    // Config
    ReloadConfigurations(1301, ActionGroup.CONFIGURE_ENGINE, false, QuotaDependency.NONE),

    // Gluster
    CreateGlusterVolume(1400, ActionGroup.CREATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    SetGlusterVolumeOption(1401, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StartGlusterVolume(1402, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StopGlusterVolume(1403, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    ResetGlusterVolumeOptions(1404, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    DeleteGlusterVolume(1405, ActionGroup.DELETE_GLUSTER_VOLUME, QuotaDependency.NONE),
    GlusterVolumeRemoveBricks(1406, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StartRebalanceGlusterVolume(1407, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    ReplaceGlusterVolumeBrick(1408, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    AddBricksToGlusterVolume(1409, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StartGlusterVolumeProfile(1410, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StopGlusterVolumeProfile(1411, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    RemoveGlusterServer(1412, ActionGroup.DELETE_HOST, QuotaDependency.NONE),
    AddGlusterFsStorageDomain(1413, ActionGroup.CREATE_STORAGE_DOMAIN, QuotaDependency.NONE),
    EnableGlusterHook(1414, ActionGroup.MANIPULATE_GLUSTER_HOOK, QuotaDependency.NONE),
    DisableGlusterHook(1415, ActionGroup.MANIPULATE_GLUSTER_HOOK, QuotaDependency.NONE),
    UpdateGlusterHook(1416, ActionGroup.MANIPULATE_GLUSTER_HOOK, QuotaDependency.NONE),
    AddGlusterHook(1417, ActionGroup.MANIPULATE_GLUSTER_HOOK, QuotaDependency.NONE),
    RemoveGlusterHook(1418, ActionGroup.MANIPULATE_GLUSTER_HOOK, QuotaDependency.NONE),
    RefreshGlusterHooks(1419, ActionGroup.MANIPULATE_GLUSTER_HOOK, QuotaDependency.NONE),
    ManageGlusterService(1420, ActionGroup.MANIPULATE_GLUSTER_SERVICE, QuotaDependency.NONE),
    StopRebalanceGlusterVolume(1421, ActionGroup.MANIPULATE_GLUSTER_VOLUME, false, QuotaDependency.NONE),
    StartRemoveGlusterVolumeBricks(1422, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StopRemoveGlusterVolumeBricks(1423, ActionGroup.MANIPULATE_GLUSTER_VOLUME, false, QuotaDependency.NONE),
    CommitRemoveGlusterVolumeBricks(1424, ActionGroup.MANIPULATE_GLUSTER_VOLUME, false, QuotaDependency.NONE),
    RefreshGlusterVolumeDetails(1425, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    RefreshGeoRepSessions(1426, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StopGeoRepSession(1427, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    DeleteGeoRepSession(1428, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    StartGlusterVolumeGeoRep(1429, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    ResumeGeoRepSession(1430, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    PauseGlusterVolumeGeoRepSession(1431, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    SetGeoRepConfig(1432, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    ResetDefaultGeoRepConfig(1433, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    DeleteGlusterVolumeSnapshot(1434, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    DeleteAllGlusterVolumeSnapshots(1435, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    ActivateGlusterVolumeSnapshot(1436, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    DeactivateGlusterVolumeSnapshot(1437, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    RestoreGlusterVolumeSnapshot(1438, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    UpdateGlusterVolumeSnapshotConfig(1439, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    SyncStorageDevices(1440, ActionGroup.MANIPULATE_HOST, QuotaDependency.NONE),
    CreateGlusterVolumeSnapshot(1441, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    ScheduleGlusterVolumeSnapshot(1442, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    RescheduleGlusterVolumeSnapshot(1443, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    CreateBrick(1444, ActionGroup.MANIPULATE_HOST, QuotaDependency.NONE),
    CreateGlusterVolumeGeoRepSession(1445, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    SetupGlusterGeoRepMountBrokerInternal(1446, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    UpdateGlusterHostPubKeyToSlaveInternal(1447, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    DisableGlusterCliSnapshotScheduleInternal(1448, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),
    SetUpPasswordLessSSHInternal(1449, ActionGroup.MANIPULATE_GLUSTER_VOLUME, QuotaDependency.NONE),

    // Scheduling Policy
    AddClusterPolicy(1450, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    EditClusterPolicy(1451, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveClusterPolicy(1452, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveExternalPolicyUnit(1453, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    // External events
    AddExternalEvent(1500, ActionGroup.INJECT_EXTERNAL_EVENTS, QuotaDependency.NONE),

    // Providers
    AddProvider(1600, false, QuotaDependency.NONE),
    UpdateProvider(1601, false, QuotaDependency.NONE),
    RemoveProvider(1602, false, QuotaDependency.NONE),
    TestProviderConnectivity(1603, false, QuotaDependency.NONE),
    ImportProviderCertificate(1604, false, QuotaDependency.NONE),
    AddNetworkOnProvider(1605, ActionGroup.CREATE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    AddSubnetToProvider(1606, false, QuotaDependency.NONE),
    RemoveSubnetFromProvider(1607, false, QuotaDependency.NONE),

    AddWatchdog(1700, ActionGroup.EDIT_VM_PROPERTIES, QuotaDependency.NONE),
    UpdateWatchdog(1701, ActionGroup.EDIT_VM_PROPERTIES, QuotaDependency.NONE),
    RemoveWatchdog(1702, ActionGroup.EDIT_VM_PROPERTIES, QuotaDependency.NONE),

    AddNetworkQoS(1750, ActionGroup.CONFIGURE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    UpdateNetworkQoS(1751, ActionGroup.CONFIGURE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    RemoveNetworkQoS(1752, ActionGroup.CONFIGURE_STORAGE_POOL_NETWORK, false, QuotaDependency.NONE),
    // qos
    AddStorageQos(1753, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    UpdateStorageQos(1754, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveStorageQos(1755, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    AddCpuQos(1756, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    UpdateCpuQos(1757, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveCpuQos(1758, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    AddHostNetworkQos(1770, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    UpdateHostNetworkQos(1771, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveHostNetworkQos(1772, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    // disk profiles
    AddDiskProfile(1760, ActionGroup.CREATE_STORAGE_DISK_PROFILE, false, QuotaDependency.NONE),
    UpdateDiskProfile(1761, ActionGroup.CONFIGURE_STORAGE_DISK_PROFILE, false, QuotaDependency.NONE),
    RemoveDiskProfile(1762, ActionGroup.DELETE_STORAGE_DISK_PROFILE, false, QuotaDependency.NONE),
    // cpu profiles
    AddCpuProfile(1763, ActionGroup.CREATE_CPU_PROFILE, false, QuotaDependency.NONE),
    UpdateCpuProfile(1764, ActionGroup.UPDATE_CPU_PROFILE, false, QuotaDependency.NONE),
    RemoveCpuProfile(1765, ActionGroup.DELETE_CPU_PROFILE, false, QuotaDependency.NONE),

    // External Tasks
    AddExternalJob(1800, ActionGroup.INJECT_EXTERNAL_TASKS, false, QuotaDependency.NONE),
    EndExternalJob(1801, ActionGroup.INJECT_EXTERNAL_TASKS, false, QuotaDependency.NONE),
    ClearExternalJob(1802, ActionGroup.INJECT_EXTERNAL_TASKS, false, QuotaDependency.NONE),
    AddExternalStep(1803, ActionGroup.INJECT_EXTERNAL_TASKS, false, QuotaDependency.NONE),
    EndExternalStep(1804, ActionGroup.INJECT_EXTERNAL_TASKS, false, QuotaDependency.NONE),

    //Internal Tasks
    AddInternalJob(1850, false, QuotaDependency.NONE),
    AddInternalStep(1851, false, QuotaDependency.NONE),

    UpdateMomPolicy(1900, ActionGroup.MANIPULATE_HOST, false, QuotaDependency.NONE),
    UploadStream(1901, QuotaDependency.NONE),
    ProcessOvfUpdateForStorageDomain(1902, QuotaDependency.NONE),
    CreateOvfVolumeForStorageDomain(1903, QuotaDependency.NONE),
    CreateOvfStoresForStorageDomain(1904, QuotaDependency.NONE),
    RetrieveImageData(1905, QuotaDependency.NONE),
    ProcessOvfUpdateForStoragePool(1906, QuotaDependency.NONE),

    // Affinity Groups
    AddAffinityGroup(1950, ActionGroup.MANIPULATE_AFFINITY_GROUPS, false, QuotaDependency.NONE),
    EditAffinityGroup(1951, ActionGroup.MANIPULATE_AFFINITY_GROUPS, false, QuotaDependency.NONE),
    RemoveAffinityGroup(1952, ActionGroup.MANIPULATE_AFFINITY_GROUPS, false, QuotaDependency.NONE),

    // ISCSI Bonds
    AddIscsiBond(2000, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    EditIscsiBond(2001, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),
    RemoveIscsiBond(2002, ActionGroup.EDIT_STORAGE_POOL_CONFIGURATION, false, QuotaDependency.NONE),

    SetHaMaintenance(2050, ActionGroup.MANIPULATE_HOST, false, QuotaDependency.NONE),

    // Rng crud
    AddRngDevice(2150, ActionGroup.EDIT_VM_PROPERTIES, QuotaDependency.NONE),
    UpdateRngDevice(2151, ActionGroup.EDIT_VM_PROPERTIES, QuotaDependency.NONE),
    RemoveRngDevice(2152, ActionGroup.EDIT_VM_PROPERTIES, QuotaDependency.NONE),

    // Graphics Device CRUD
    AddGraphicsDevice(2250, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),
    UpdateGraphicsDevice(2251, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),
    RemoveGraphicsDevice(2252, ActionGroup.EDIT_VM_PROPERTIES, false, QuotaDependency.NONE),

    // Vm Host Device CRUD
    AddVmHostDevices(2350, ActionGroup.EDIT_ADMIN_VM_PROPERTIES, false, QuotaDependency.NONE),
    RemoveVmHostDevices(2351, ActionGroup.EDIT_ADMIN_VM_PROPERTIES, false, QuotaDependency.NONE),

    // Audit Log
    RemoveAuditLogById(2100, false, QuotaDependency.NONE),
    ClearAllAuditLogEvents(2101, false, QuotaDependency.NONE),
    DisplayAllAuditLogEvents(2102, false, QuotaDependency.NONE),
    ClearAllAuditLogAlerts(2103, false, QuotaDependency.NONE),
    DisplayAllAuditLogAlerts(2104, false, QuotaDependency.NONE),

    SetSesssionSoftLimit(3000, false, QuotaDependency.NONE),

    // Mac Pool
    AddMacPool(3100, ActionGroup.CREATE_MAC_POOL, false, QuotaDependency.NONE),
    UpdateMacPool(3101, ActionGroup.EDIT_MAC_POOL, false, QuotaDependency.NONE),
    RemoveMacPool(3102, ActionGroup.DELETE_MAC_POOL, false, QuotaDependency.NONE),

    // Cinder
    AddCinderDisk(3200, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.STORAGE),
    RemoveCinderDisk(3201, QuotaDependency.STORAGE),
    ExtendCinderDisk(3202, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.STORAGE),
    RemoveAllVmCinderDisks(3203, QuotaDependency.STORAGE),
    CloneSingleCinderDisk(3204, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.STORAGE),
    CloneCinderDisks(3205, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.STORAGE),
    RegisterCinderDisk(3206, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.NONE),
    CreateCinderSnapshot(3207, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    RemoveCinderSnapshotDisk(3208, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    AddLibvirtSecret(3209, false, QuotaDependency.NONE),
    UpdateLibvirtSecret(3210, false, QuotaDependency.NONE),
    RemoveLibvirtSecret(3211, false, QuotaDependency.NONE),
    TryBackToCinderSnapshot(3212, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    TryBackToAllCinderSnapshots(3213, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    RestoreFromCinderSnapshot(3214, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    RestoreAllCinderSnapshots(3215, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    RemoveAllCinderSnapshotDisks(3216, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),
    FreezeVm(3217, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.NONE),
    ThawVm(3218, ActionGroup.CONFIGURE_VM_STORAGE, QuotaDependency.NONE),
    RemoveCinderDiskVolume(3219, QuotaDependency.STORAGE),
    CreateAllCinderSnapshots(3220, ActionGroup.CONFIGURE_VM_STORAGE, false, QuotaDependency.STORAGE),

    // Host Devices
    RefreshHostDevices(4000, ActionGroup.MANIPULATE_HOST, false, QuotaDependency.NONE),
    RefreshHost(4001, ActionGroup.MANIPULATE_HOST, false, QuotaDependency.NONE),

    // Network Attachments
    HostSetupNetworks(5200, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    AddNetworkAttachment(5201, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    UpdateNetworkAttachment(5202, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    RemoveNetworkAttachment(5203, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),
    PersistentHostSetupNetworks(5204, QuotaDependency.NONE),
    SyncAllHostNetworks(5205, ActionGroup.CONFIGURE_HOST_NETWORK, QuotaDependency.NONE),

    // Hosted Engine
    ImportHostedEngineStorageDomain(6000, false, QuotaDependency.NONE);

    private int intValue;
    private ActionGroup actionGroup;
    private boolean isActionMonitored;
    private static final HashMap<Integer, VdcActionType> mappings = new HashMap<>();
    private QuotaDependency quotaDependency;
    private boolean quotaDependentAsInternalCommand = false;

    static {
        for (VdcActionType action : values()) {
            mappings.put(action.getValue(), action);
        }
    }

    private VdcActionType(int value , QuotaDependency quotaDependency) {
        this(value, null, quotaDependency);
    }

    private VdcActionType(int value, boolean isActionMonitored, QuotaDependency quotaDependency) {
        this(value, null, isActionMonitored, quotaDependency);
    }

    private VdcActionType(int value, ActionGroup actionGroupValue, QuotaDependency quotaDependency) {
        this(value, actionGroupValue, true, quotaDependency);
    }

    private VdcActionType(int value, ActionGroup actionGroupValue, boolean isActionMonitored, QuotaDependency quotaDependency) {
        this.intValue = value;
        this.actionGroup = actionGroupValue;
        this.isActionMonitored = isActionMonitored;
        this.quotaDependency = quotaDependency;
    }

    private VdcActionType(int value,
            ActionGroup actionGroupValue,
            boolean isActionMonitored,
            QuotaDependency quotaDependency,
            boolean quotaDependentAsInternalCommand) {
        this(value, actionGroupValue, isActionMonitored, quotaDependency);
        this.quotaDependentAsInternalCommand = quotaDependentAsInternalCommand;
    }


    public int getValue() {
        return intValue;
    }

    public ActionGroup getActionGroup() {
        return actionGroup;
    }

    public boolean isActionMonitored() {
        return isActionMonitored;
    }

    public static VdcActionType forValue(int value) {
        return mappings.get(value);
    }

    public QuotaDependency getQuotaDependency() {
        return quotaDependency;
    }

    public boolean isQuotaDependentAsInternalCommand() {
        return quotaDependentAsInternalCommand;
    }

    /**
     * The QuotaDependency marks on which kind of quota regulated resources each command is dependant.
     * i.e. - Creating new Disk is dependant of Storage resources. Running a VM is dependant of VDS (cluster) resources.
     *
     * NONE - indicates no dependency of any quota regulated resources.
     *
     * !!! Notice !!! - marking your command with QuotaDependency is not enough. In order to avoid Exceptions and
     * Quota consumption errors, the command must implement the correct interface: STORAGE=>QuotaStorageDependant,
     * VDS=>QuotaVdsDependant, BOTH=>QuotaStorageDependant and QuotaVdsDependant
     */
    public enum QuotaDependency {
        NONE, STORAGE, VDS_GROUP, BOTH
    }
}
