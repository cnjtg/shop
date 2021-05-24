<template>
  <div class="login">
    <div class="login_box">

      <el-form ref="loginFromRef" :rules="rules" :model="loginForm" label-width="0px" class="login_form">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-user" v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input prefix-icon="el-icon-lock" type="password" v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login">登 录</el-button>
          <el-button type="info" @click="reset">重 置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
      },
      rules: {
        username: [
          {require: true, message: '账号必填', trigger: 'blur'},
          {min: 3, max: 100, message: '账号长度最多100个字符', trigger: 'blur'},
        ]
      }
    }
  },
  methods: {
    reset() {
      this.$refs.loginFromRef.resetFields();
    },
    login() {
      this.$refs.loginFromRef.validate(async valid =>  {
        if(valid){
          const {data} = await this.$http.post("login",this.loginForm);
          if(data.code === 200){
            this.$message.success('登录成功！')
          }else this.$message.error(data.message)
        }
      })
    }
  }
}
</script>

<style scoped>
.login {
  background-color: #2b4b6b;
  height: 100%;
}

.login_box {
  width: 450px;
  height: 300px;
  background-color: aliceblue;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.login_form {
  position: absolute;
  bottom: 0;
  padding: 0 20px;
  width: 100%;
  box-sizing: border-box;
}
</style>
