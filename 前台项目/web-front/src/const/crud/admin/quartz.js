
export const tableOption = {
  border: true,
  index: true,
  indexLabel: '序号',
  indexFixed: true,
  menuAlign: 'center',
  align: 'center',
  refreshBtn: true,
  showClomnuBtn: true,
  searchSize: 'mini',
  labelWidth: 150,
  dialogWidth:'80%',
  dialogHeight: 500,
  addBtn: false,
  editBtn: false,
  delBtn: false,
  viewBtn: false,
  props: {
    label: 'label',
    value: 'value'
  },
  column: [{
    label: '任务名称',
    width: 150,
    prop: 'jobName',
    rules: [{
      required: true,
      message: '请输入任务名称',
      trigger: 'blur'
    }],
    search: true
  }, {
    label: '任务组名',
    prop: 'jobGroup',
    width: 150,
    rules: [{
      required: true,
      message: '请输入任务组名',
      trigger: 'blur'
    }],
    search: true
  }, {
    label: '任务状态',
    prop: 'jobStatus',
    addDisplay: false,
    editDisplay: false,
    width: 150,
    type:'select',
    slot:true,
    dicUrl: '/admin/dict/item/type/job_status',
    search: true
  }, {
    label: '执行状态',
    width: 150,
    addDisplay: false,
    editDisplay: false,
    slot:true,
    dicUrl: '/admin/dict/item/type/job_execute_status',
    type:'select',
    prop: 'jobExecuteStatus',
    search: true
  }, {
    label: '首次执行时间',
    prop: 'startTime',
    type: 'datetime',
    width: 250,
    addDisplay: false,
    editDisplay: false,
    format: 'yyyy-MM-dd HH:mm',
    valueFormat: 'yyyy-MM-dd HH:mm:ss'
  }, {
    label: '上次执行时间',
    width: 250,
    prop: 'previousTime',
    type: 'datetime',
    addDisplay: false,
    editDisplay: false,
    format: 'yyyy-MM-dd HH:mm',
    valueFormat: 'yyyy-MM-dd HH:mm:ss'
  }, {
    label: '下次执行时间',
    prop: 'nextTime',
    type: 'datetime',
    width: 250,
    addDisplay: false,
    editDisplay: false,
    format: 'yyyy-MM-dd HH:mm',
    valueFormat: 'yyyy-MM-dd HH:mm:ss'
  }, {
    label: '任务类型',
    width: 150,
    rules: [{
      required: true,
      message: '请选择任务类型',
      trigger: 'blur'
    }],
    prop: 'jobType',
    type: 'select',
    dicUrl: '/admin/dict/item/type/job_type',
  }, {
    label: '执行路径',
    width: 150,
    prop: 'executePath'
  }, {
    label: '执行文件',
    width: 150,
    prop: 'className'
  }, {
    label: '执行方法',
    width: 150,
    prop: 'methodName'
  }, {
    label: '执行参数值',
    width: 150,
    prop: 'methodParamsValue'
  }, {
    label: 'cron表达式',
    width: 150,
    rules: [{
      required: true,
      message: '请输入Cron表达式',
      trigger: 'blur'
    }],
    formslot:true,
    prop: 'cronExpression'
  }, {
    label: '错失执行策略',
    width: 150,
    rules: [{
      required: true,
      message: '请选择错失执行策略',
      trigger: 'blur'
    }],
    dicUrl: '/admin/dict/item/type/misfire_policy',
    type:'select',
    prop: 'misfirePolicy'
  }, {
    label: '备注信息',
    width: 150,
    prop: 'remark'
  }]
}

export const logTableOption = {
  border: true,
  menuAlign: 'center',
  align: 'center',
  refreshBtn: true,
  columnBtn:false,
  menu:false,
  addBtn: false,
  editBtn: false,
  delBtn: false,
  viewBtn: false,
  column: [{
    label: '任务名称',
    width: 100,
    prop: 'jobName',
  }, {
    label: '任务组名',
    prop: 'jobGroup',
    width: 100,
  }, {
    label: '状态',
    prop: 'jobLogStatus',
    width: 100,
    slot:true,
    dicUrl: '/admin/dict/item/type/job_execute_status',
  },{
    label: '类型',
    width: 150,
    prop: 'jobType',
    dicUrl: '/admin/dict/item/type/job_type',
  }, {
    label: '执行路径',
    width: 150,
    prop: 'executePath'
  }, {
    label: '执行文件',
    width: 120,
    prop: 'className'
  }, {
    label: '执行方法',
    width: 120,
    prop: 'methodName'
  }, {
    label: '执行参数值',
    width: 120,
    prop: 'methodParamsValue'
  }, {
    label: 'cron表达式',
    width: 120,
    prop: 'cronExpression'
  },{
    label: '状态描述',
    width: 120,
    prop: 'jobMessage'
  },{
    label: '执行时间(ms)',
    width: 120,
    prop: 'executeTime'
  },{
    label: '异常信息',
    width: 150,
    slot:true,
    prop: 'exceptionInfo'
  },{
    label: '开始时间',
    width: 150,
    prop: 'createTime',
    format: 'yyyy-MM-dd HH:mm',
    valueFormat: 'yyyy-MM-dd HH:mm:ss'
  },]
}
