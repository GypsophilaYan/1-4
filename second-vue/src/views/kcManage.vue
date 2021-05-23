  <template>
  <div>
    <div style="margin-top:50px;">
      <el-input v-model="kcname" placeholder="请输入课程名称" style="width:80%" clearable></el-input>
      <el-button type="primary" style="margin-left: 10px;" @click="searchStudentByName">搜索</el-button>
      <el-button type="primary" style="margin-left:10px;margin-bottom: 20px;" @click="showDialog">新增课程</el-button>
    </div>
    <div>
      <el-table
              @selection-change="handleSelectionChange"
              :data="students"
              border>
        <el-table-column
                type="selection"
                width="55">
        </el-table-column>
			<el-table-column
                prop="kcname"
                label="课程名称"
                width="120">
        </el-table-column>
        	<el-table-column
                prop="kcnumber"
                label="课程编号"
                width="120">
        </el-table-column>
			<el-table-column
                prop="kctype"
                label="课程类型"
                width="120">
        </el-table-column>
			<el-table-column
                prop="kccollege"
                label="开课学院"
                width="120">
        </el-table-column>
			<el-table-column
                prop="kcroom"
                label="开课教室"
                width="120">
        </el-table-column>
			<el-table-column
                prop="kctimes"
                label="课时"
                width="120">
        </el-table-column>
			<el-table-column
                prop="kcduration"
                label="单节时长（分钟）"
                width="140">
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
                    type="primary"
                    @click="kcDetail(scope.row)">展示</el-button>
            <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button type="danger" size="mini" style="margin-top: 12px" :disabled="multipleSelection.length === 0" @click="deleteStudents">批量删除</el-button>
    </div>
    <el-dialog :title="dialogTitle[dialogStatus]" :visible.sync="dialogFormVisible" center>
      <el-form :model="kcInfo" :rules="rules" ref="student">
        <el-form-item label="课程名称" :label-width="formLabelWidth" prop="kcname">
          <el-input v-model="kcInfo.kcname" placeholder="课程名称" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程编号" :label-width="formLabelWidth" prop="kcnumber">
          <el-input v-model="kcInfo.kcnumber" placeholder="课程编号" autocomplete="off"></el-input>
        </el-form-item>
         
         <el-form-item label="课程类型" :label-width="formLabelWidth" prop="kctype">
          <el-select v-model="kcInfo.kctype" placeholder="请选择" style="width: 100%">
            <el-option
                    v-for="item in types"
                    :key="item.value"
                    :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
         <el-form-item label="开课学院" :label-width="formLabelWidth" prop="kccollege">
          <el-select v-model="kcInfo.kccollege" placeholder="请选择" style="width: 100%">
            <el-option
                    v-for="item in colleges"
                    :key="item.value"
                    :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
         <el-form-item label="开课教室" :label-width="formLabelWidth" prop="kcroom">
          <el-select v-model="kcInfo.kcroom" placeholder="请选择" style="width: 100%">
            <el-option
                    v-for="item in rooms"
                    :key="item.value"
                    :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
         <el-form-item label="课程课时" :label-width="formLabelWidth" prop="kctimes">
          <el-input v-model="kcInfo.kctimes" placeholder="多少节课" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="单节课时" :label-width="formLabelWidth" prop="kcduration">
          <el-input v-model="kcInfo.kcduration" placeholder="一节课多少分钟" autocomplete="off"></el-input>
        </el-form-item>
         <el-form-item label="课程介绍" :label-width="formLabelWidth" prop="kcintroduce">
          <el-input v-model="kcInfo.kcintroduce" placeholder="课程介绍"  autocomplete="off" type="textarea" :autosize="{ minRows: 10, maxRows: 100}"></el-input>
        </el-form-item>
         <!-- <el-form-item label="性别" :label-width="formLabelWidth" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择" style="width: 100%">
            <el-option
                    v-for="item in options"
                    :key="item.value"
                    :value="item.label">
            </el-option>
          </el-select>
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
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitStudent">确 定</el-button>
      </div>
    </el-dialog>
    <!-- <el-upload
            style="margin-top:20px;"
            action="/upload"
            multiple
            :on-success="handleSuccess"
            :limit="3"
            :file-list="fileList">
      <el-button size="small" type="primary">点击上传</el-button>
    </el-upload> -->
  </div>
</template>

<script>
// @ is an alias to /src


export default {
  name: 'Home',
  components: {
  },
  data () {
    return {
      fileList: [],
      kcname: '',
      multipleSelection:[],
      dialogTitle: {
        addStudent: "新增课程",
        editStudent: "编辑课程"
      },
      dialogStatus: "",
      rules: {
        name: [
          { required: true, message: '请输入姓名', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        age: [
          { required: true, message: '年龄不能为空'},
          { type: 'number', message: '年龄必须为数字值'}
        ]
      },
       types: [{
        value: '1',
        label: '必修'
      }, {
        value: '2',
        label: '选修'
      }],
       colleges: [{
        value: '1',
        label: '计算机学院'
      }, {
        value: '2',
        label: '土木工程学院'
      }, {
        value: '3',
        label: '外国语学院'
      }, {
        value: '4',
        label: '公商管理学院'
      }],
       rooms: [{
        value: '1',
        label: '1号教室'
      }, {
        value: '2',
        label: '2号教室'
      }, {
        value: '3',
        label: '3号教室'
      }, {
        value: '4',
        label: '4号教室'
      }],
      options: [{
        value: '1',
        label: '男'
      }, {
        value: '2',
        label: '女'
      }],
      msg: '',
      students:[],
      search: '',
      dialogFormVisible: false,
      form: {
        name: '',
        age: '',
        sex: ''
      },
      kcInfo: {
        id:null,
        kcnumber: '',
        kcname: '',
        kctype: '',
        kccollege: '',
        kcroom: '',
        kctimes: '',
        kcduration: '',
        kcintroduce: ''
      },
      formLabelWidth: '120px',
    }
  },
  created() {
    this.findAllStudents();
  },
  watch:{
    studentName () {
        this.findAllStudents();
    }
  },
  methods: {
    // deleteFile (file) {
    //   console.log(file)
    // },
    handleSuccess (file) {
      const filename = file.name;
      this.$message({
        message: '文件上传成功！',
        type: 'success'
      });
    },
    searchStudentByName () {
       
            this.$axios.get("/kc/findKcByName?kcname="+this.kcname).then( (resp)=> {
                this.students = resp.data;
            }).catch( (error)=>{
                this.$message({
                    type: 'error',
                    message: "查询失败，原因是"+error.data.message
                });
            })
        
    },
    deleteStudents () {
      this.$confirm('此操作将永久删除课程, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let ids = '?';
        this.multipleSelection.forEach( (item)=>{
          ids += 'ids='+item.id+'&'
        });
        this.$axios.post("/kc/deleteKcs"+ids).then( (resp)=> {
          if (resp) {
            this.findAllStudents();
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
    submitStudent () {
      if (this.dialogStatus === 'addStudent'){
        this.addStudent();
      } else if(this.dialogStatus === "editStudent") {
        this.editStudent();
      }
    },
    findAllStudents () {
      this.$axios.get("/kc/findAll")
              .then((res) => {
                this.students = res.data
              })
              .catch(error => {
                this.$message({
                  type: 'error',
                  message: "查询失败，原因是"+error.data.message
                });
              });
    },
    handleEdit (row) {
      this.dialogFormVisible = true;
      this.dialogStatus = "editStudent";
      // this.form.uid = row.uid;
      // this.form.name = row.name;
      // this.form.age = row.age;
      // this.form.sex = row.sex;

      this.kcInfo.id= row.id;
      this.kcInfo.kcnumber= row.kcnumber;
      this.kcInfo.kcname= row.kcname;
      this.kcInfo.kctype= row.kctype;
      this.kcInfo.kccollege= row.kccollege;
      this.kcInfo.kcroom= row.kcroom;
      this.kcInfo.kctimes= row.kctimes;
      this.kcInfo.kcduration= row.kcduration;
      this.kcInfo.kcintroduce= row.kcintroduce;
    },
     kcDetail (row) {
      this.$router.push({path:'/kcDetail',query:{kcName:row.kcname,kcintroduce:row.kcintroduce}});
    },
    handleDelete (row) {
      this.$confirm('此操作将永久删除该课程, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.post("/kc/deleteKc?id="+row.id).then ((resp)=>{
          this.$message.success("删除成功!")
          this.findAllStudents();
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    showDialog () {
      this.kcInfo.kcnumber= '';
      this.kcInfo.kcname= '';
      this.kcInfo.kctype= '';
      this.kcInfo.kccollege= '';
      this.kcInfo.kcroom= '';
      this.kcInfo.kctimes='';
      this.kcInfo.kcduration= '';
      this.kcInfo.kcintroduce= '';
      this.dialogFormVisible = true;
      this.dialogStatus = "addStudent";
    },
    addStudent () {
      this.$refs.student.validate((valid) => {
        if (valid) {
          this.$axios.post("/kc/addKc",this.kcInfo).then( (resp)=>{
            if (resp) {
              this.dialogFormVisible = false;
              this.$message.success("添加成功！");
              this.findAllStudents();
            }
          }).catch((error)=>{
            this.$message({
              message: '添加数据失败，原因是'+error.data.message,
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
    editStudent () {
      this.$axios.post("/kc/updateKc",this.kcInfo).then( (resp)=>{
        this.dialogFormVisible = false;
        this.$message.success("修改成功!");
        this.findAllStudents();
      }).catch( (error)=> {
        this.$message({
          message: '数据更新失败，原因是'+error.data.message,
          type: 'error'
        })
      })
    }
  }
}
</script>
<style scoped>
  .table {
    margin: 0 auto;
    clear: both;
  }
</style>
