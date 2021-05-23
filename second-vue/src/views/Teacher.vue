<template>
  <div>
    <div style="margin-top:50px;">
      <el-input v-model="teacherName" placeholder="请输入教师姓名" style="width:80%" clearable></el-input>
      <el-button type="primary" style="margin-left: 10px;" @click="searchTeacherByName">搜索</el-button>
      <el-button type="primary" style="margin-left:10px;margin-bottom: 20px;" @click="showDialog">新增教师</el-button>
    </div>
    <div>
      <el-table
          @selection-change="handleSelectionChange"
          :data="teachers"
          border>
        <el-table-column
            type="selection"
            width="55">
        </el-table-column>
        <el-table-column
            prop="uid"
            label="学号"
            width="120">
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            width="120">
        </el-table-column>
        <el-table-column
            prop="sex"
            label="性别"
            width="120">
        </el-table-column>
        <el-table-column
            prop="age"
            label="年龄"
            width="120">
        </el-table-column>

        <el-table-column
            prop="college"
            label="学院"
            width="120">
        </el-table-column>
        <el-table-column
            prop="major"
            label="专业"
            width="120">
        </el-table-column>

        <el-table-column
            prop="marriage"
            label="婚姻状况"
            width="120">
        </el-table-column>


        <el-table-column
            prop="work"
            label="工作状态"
            width="120">
        </el-table-column>

        <el-table-column
            prop="address"
            label="家庭地址"
            width="120">
        </el-table-column>


        <el-table-column
            prop="bloodType"
            label="血型"
            width="120">
        </el-table-column>



        <el-table-column
            prop="phone"
            label="手机号"
            width="120">
        </el-table-column>

        <el-table-column
            prop="email"
            label="QQ邮箱"
            width="120">
        </el-table-column>


        <el-table-column
            prop="date"
            label="入职时间"
            width="120">
        </el-table-column>

        <el-table-column
            prop="hobby"
            label="兴趣爱好"
            width="120">
        </el-table-column>
        <el-table-column
            prop="nation"
            label="民族"
            width="120">
        </el-table-column>

        <el-table-column
            prop="salary"
            label="工资"
            width="120">
        </el-table-column>


        <el-table-column
            label="操作">
          align="left">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.row)">编辑</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button type="danger" size="mini" style="margin-top: 12px" :disabled="multipleSelection.length === 0" @click="deleteTeachers">批量删除</el-button>
    </div>
    <el-dialog :title="dialogTitle[dialogStatus]" :visible.sync="dialogFormVisible" center>
      <el-form :model="form" :rules="rules" ref="teacher">
        <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择" style="width: 100%">
            <el-option
                v-for="item in options"
                :key="item.value"
                :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth" prop="age">
          <el-input v-model.number="form.age" autocomplete="off"></el-input>
        </el-form-item>

        <!----------------------------添加部分--------------------------------------->
        <el-form-item label="学院" :label-width="formLabelWidth" prop="college">
          <el-input v-model.number="form.college" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="专业" :label-width="formLabelWidth" prop="major">
          <el-input v-model.number="form.major" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="婚姻状况" :label-width="formLabelWidth" prop="marriage">
          <el-select v-model="form.marriage" placeholder="请选择" style="width: 100%">
            <el-option
                v-for="item in optionsMarriage"
                :key="item.value"
                :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工作状态" :label-width="formLabelWidth" prop="work">
          <el-radio-group v-model="form.work">
            <el-radio-button label="已退休"></el-radio-button>
            <el-radio-button label="未退休"></el-radio-button>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="家庭地址" :label-width="formLabelWidth" prop="address">

          <el-cascader
              v-model="form.address"
              :options="optionMenu"
              :props="{ expandTrigger: 'hover' }"  clearable>

          </el-cascader>
        </el-form-item>



        <el-form-item label="血型" :label-width="formLabelWidth" prop="bloodType">
          <el-radio-group v-model="form.bloodType">
            <el-radio label="A"></el-radio>
            <el-radio label="B"></el-radio>
            <el-radio label="AB"></el-radio>
            <el-radio label="O"></el-radio>
          </el-radio-group>
        </el-form-item>


        <el-form-item label="手机号" :label-width="formLabelWidth" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="QQ邮箱" :label-width="formLabelWidth" prop="email">
          <el-input v-model="form.email" placeholder="请输入QQ邮箱" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="入职时间" :label-width="formLabelWidth" prop="date">
          <el-date-picker
            v-model="form.date"
            type="month"
            placeholder="选择月"
            format = "yyyy 年  MM 月"
            value-format = "yyyy-MM">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="兴趣爱好" :label-width="formLabelWidth" prop="hobby">
<!--          <el-form-item>{{form.hobbys}}</el-form-item>-->
          <el-checkbox-group v-model="form.hobbys" >
            <el-checkbox label="打游戏" ></el-checkbox>
            <el-checkbox label="睡觉"></el-checkbox>
            <el-checkbox label="听音乐"></el-checkbox>
            <el-checkbox label="唱歌" ></el-checkbox>
            <el-checkbox label="打篮球" ></el-checkbox>
          </el-checkbox-group>


        </el-form-item>


        <el-form-item label="民族" :label-width="formLabelWidth" prop="nation">
          <el-select v-model="form.nation" placeholder="请选择" style="width: 100%">
            <el-option
                v-for="item in optionNation"
                :key="item.value"
                :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="工资" :label-width="formLabelWidth" prop="salary">
          <el-input v-model="form.salary" autocomplete="off"></el-input>
        </el-form-item>



      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitTeacher">确 定</el-button>
      </div>
    </el-dialog>
    <el-upload
        style="margin-top:20px;"
        action="/upload"
        multiple
        :on-success="handleSuccess"
        :limit="3"
        :file-list="fileList">
      <el-button size="small" type="primary">点击上传</el-button>
    </el-upload>
  </div>
</template>

<script>
// @ is an alias to /src


export default {
  name: 'Home',
  components: {},
  data() {
    return {

      fileList: [],
      teacherName: '',
      multipleSelection: [],
      dialogTitle: {
        addTeacher: "新增教师",
        editTeacher: "编辑教师"
      },
      dialogStatus: "",
      rules: {

        name: [
          {required: true, message: '姓名不能为空', trigger: 'blur'},

          {validator:function (rule,value,callback){
              const reg =/^[\u4e00-\u9fa5]{2,5}$/;
              if(!value) {
                return callback(new Error("请输入姓名！"))
              }else if (!reg.test(value)) {
                return callback(new Error("姓名只能为2-5个汉字"))
              }else{
                callback()
              }
            }}
        ],
        sex: [
          {required: true, message: '请选择性别', trigger: 'change'}
        ],
        age: [
          {required: true, message: '年龄不能为空'},
          {type: 'number', message: '年龄必须为数字值'},
          {validator:function (rule,value,callback){
              const reg =/^[（2 | 3 | 4 | 5）][0-9]$/;
              if(!value) {
                return callback(new Error("请输入年龄！"))
              }else if (!reg.test(value)) {
                return callback(new Error("年龄只能为20-59"))
              }else{
                callback()
              }
            }}
        ],
        college: [
          {required: true, message: '请输入学院', trigger: 'blur'}
        ],
        major: [
          {required: true, message: '请输入专业', trigger: 'blur'}
        ],

        phone: [
          { required: true, message: '手机号不能为空' },
          { type: 'number',
            message: '手机号格式不正确',
            transform (valueNumber) {
              var phonereg = 11 && /^((13|14|15|16|17|18|19)[0-9]{1}\d{8})$/
              if (!phonereg.test(valueNumber)) {
                return false
              }else{
                return Number(valueNumber)
              }
            }
          }
        ],

        email: [
          { required: true, message: 'QQ邮箱不能为空',trigger: 'blur' },
          {validator:function (rule,value,callback){
            const reg =/^[0-9]{2,17}@qq.com$/;
            if(!value) {
              return callback(new Error("请填写邮箱！"))
            }else if (!reg.test(value)) {
              return callback(new Error("请填写正确的邮箱格式"))
            }else{
              callback()
            }
            }}
        ],

        salary: [
          {required: true, message: '工资不能为空'},
          // {type: 'number', message: '工资必须为数字值'}
          {validator:function (rule,value,callback){
              // const reg =/^[0-9]*|[0-9]*.[0-9]*$/;    //正则表达式内不要随意添加空格
              const reg =/\d{1,10}(\.\d{1,2})?$/;   //正则表达式内不要随意添加空格

              if(!value) {
                return callback(new Error("工资不能为空!！"))
              }else if (!reg.test(value)) {
                return callback(new Error("输入格式不对"))
              }else{
                callback()
              }
            }}
        ],



      },
      options: [{
        value: '1',
        label: '男'
      }, {
        value: '2',
        label: '女'
      }],
      //选择婚姻状况的选项
      optionsMarriage: [{
        value: '1',
        label: '未婚'
      }, {
        value: '2',
        label: '已婚'
      }],

      optionMenu: [
        {
          value: '重庆',
          label: '重庆',
          children: [{
            value: '万州区',
            label: '万州区',
          }, {
            value: '涪陵区',
            label: '涪陵区',
          }, {
            value: '渝中区',
            label: '渝中区',
          }, {
            value: '大渡口区',
            label: '大渡口区',
          }, {
            value: '江北区',
            label: '江北区',
          }, {
            value: '沙坪坝区',
            label: '沙坪坝区',
          }]
        }, {
          value: '四川',
          label: '四川',
          children: [{
            value: '成都',
            label: '成都',
          }, {
            value: '达州',
            label: '达州',
          }, {
            value: '绵阳',
            label: '绵阳',
          }, {
            value: '广安',
            label: '广安',
          }, {
            value: '巴中',
            label: '巴中',
          }, {
            value: '广元',
            label: '广元',
          }]
        }, {
          value: '北京',
          label: '北京',
          children: [{
            value: '东城区',
            label: '东城区'
          }, {
            value: '西城区',
            label: '西城区'
          }, {
            value: '朝阳区',
            label: '朝阳区'
          }, {
            value: '丰台区',
            label: '丰台区'
          }]
        }
      ],

      optionNation: [{
        value: '1',
        label: '汉族'
      }, {
        value: '2',
        label: '回族'
      }, {
      value: '3',
          label: '维吾尔族'
    }, {
        value: '4',
        label: '苗族'
      }, {
        value: '5',
        label: '藏族'
      }, {
        value: '6',
        label: '土家族'
      }, {
        value: '7',
        label: '满族'
      }, {
        value: '8',
        label: '壮族'
      }],

      msg: '',
      teachers: [],
      search: '',
      dialogFormVisible: false,
      form: {
        name: '',
        age: '',
        sex: '',
        college: '',
        major: '',
        marriage: '',
        work: '',
        address: '',
        bloodType: '',
        // salary:''
        phone: '',
        email:'',
        date:'',
        hobby:'',
        hobbys:[],
        nation:'',
        salary:'',

      },
      formLabelWidth: '120px',
    }
  },


  created() {
    this.findAllTeachers();
  },
  watch: {
    teacherName() {
      this.findAllTeachers();
    }
  },
  methods: {
    // deleteFile (file) {
    //   console.log(file)
    // },
    handleSuccess(file) {
      const filename = file.name;
      this.$message({
        message: '文件上传成功！',
        type: 'success'
      });
    },
    searchTeacherByName() {
      if (this.teacherName !== '') {
        this.$axios.get("/teacher/findTeacherByName?name=" + this.teacherName).then((resp) => {
          this.teachers = resp.data;
        }).catch((error) => {
          this.$message({
            type: 'error',
            message: "查询失败，原因是" + error.data.message
          });
        })
      }
    },
    deleteTeachers() {
      this.$confirm('此操作将永久删除教师, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let ids = '?';
        this.multipleSelection.forEach((item) => {
          ids += 'ids=' + item.uid + '&'
        });
        this.$axios.post("/teacher/deleteTeachersByIds" + ids).then((resp) => {
          if (resp) {
            this.findAllTeachers();
            this.$message.success("删除成功！");
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(val)
    },
    submitTeacher() {
      if (this.dialogStatus === 'addTeacher') {
        this.addTeacher();
      } else if (this.dialogStatus === "editTeacher") {
        this.editTeacher();
      }
    },
    findAllTeachers() {
      this.$axios.get("/teacher/findAllTeachers")
          .then((res) => {
            this.teachers = res.data
          })
          .catch(error => {
            this.$message({
              type: 'error',
              message: "查询失败，原因是" + error.data.message
            });
          });
    },
    handleEdit(row) {
      this.dialogFormVisible = true;
      this.dialogStatus = "editTeacher";
      this.form.uid = row.uid;
      this.form.name = row.name;
      this.form.age = row.age;
      this.form.sex = row.sex;

      this.form.college = row.college;
      this.form.major = row.major;
      this.form.marriage = row.marriage;
      this.form.work = row.work;
      this.form.address = row.address.split("/");
      this.form.bloodType = row.bloodType;
      // this.form.salary = row.salary;
      this.form.phone = row.phone;
      this.form.email = row.email;
      this.form.date = row.date;
      this.form.hobby=row.hobby;
      this.form.hobbys = row.hobby.split(",");
      this.form.nation=row.nation;
      this.form.salary=row.salary;


    },
    handleDelete(row) {
      this.$confirm('此操作将永久删除该教师, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.post("/teacher/deleteTeacher?uid=" + row.uid).then((resp) => {
          this.$message.success("删除成功!")
          this.findAllTeachers();
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    showDialog() {
      this.form.uid = '';
      this.form.name = '';
      this.form.age = '';
      this.form.sex = '';
      this.form.college = '';
      this.form.major = '';
      this.form.marriage = '';
      this.form.work = '';
      this.form.address = [];
      this.form.bloodType = '';
      // this.form.salary = '';
      this.form.phone = '';
      this.form.email='';
      this.form.date='';
      this.form.hobby='';
      this.form.nation='';
      this.form.salary='';



      this.dialogFormVisible = true;
      this.dialogStatus = "addTeacher";
    },
    addTeacher() {
      this.$refs.teacher.validate((valid) => {
        if (valid) {
          this.form.hobby = this.form.hobbys.join(",");
          this.form.address = this.form.address.join("/");
          this.$axios.post("/teacher/addTeacher", this.form).then((resp) => {
            if (resp) {
              this.dialogFormVisible = false;
              this.$message.success("添加成功！");
              this.findAllTeachers();
            }
          }).catch((error) => {
            this.$message({
              message: '添加数据失败，原因是' + error.data.message,
              type: 'error'
            })
          })
        } else {
          this.$message({
            message: '请输入所有字段',
            type: 'error'
          })
          return false;
        }
      });
    },
    editTeacher() {
      this.form.hobby = this.form.hobbys.join(",");
      this.form.address = this.form.address.join("/");
      this.$axios.post("/teacher/updateTeacher", this.form).then((resp) => {
        this.dialogFormVisible = false;
        this.$message.success("修改成功!");
        this.findAllTeachers();
      }).catch((error) => {
        this.$message({
          message: '数据更新失败，原因是' + error.data.message,
          type: 'error'
        })
      })
    },

  }
}
</script>
<style scoped>
.table {
  margin: 0 auto;
  clear: both;
}
</style>

