<template>
  <div class="login-container">
    <el-form
      :model="loginData"
      :rules="loginDataRule"
      status-icon
      ref="loginData"
      label-position="left"
      label-width="0px"
      class="demo-ruleForm login-page"
      @keyup.enter.native="login()"
    >
      <h3 class="title">管理员登录</h3>
      <el-form-item prop="username">
        <el-input
          type="text"
          v-model="loginData.username"
          auto-complete="off"
          placeholder="用户名"
        ></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          v-model="loginData.password"
          auto-complete="off"
          placeholder="密码"
        ></el-input>
      </el-form-item>
      <!-- <el-checkbox v-model="checked" class="rememberme">记住密码</el-checkbox> -->
      <el-form-item prop="captcha">
              <el-row :gutter="20">
                <el-col :span="9">
                  <el-input v-model="loginData.captcha" placeholder="验证码">
                  </el-input>
                </el-col>
                <el-col :span="10" class="login-captcha">
                  <img :src="captchaPath" @click="getCaptcha()" alt="">
                </el-col>
              </el-row>
            </el-form-item>
      <el-form-item style="width: 100%">
        <el-button
          type="primary"
          style="width: 100%"
          @click="login"
          :loading="logining"
          >登录</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { createUuid } from '@/utils'
export default {
  data () {
    return {
      logining: false,
      loginData: {
        username: '',
        password: '',
        captcha: '',
        uuid: ''
      },
      captchaPath: '',
      loginDataRule: {
        username: [
          {
            required: true,
            message: '账号不能为空',
            trigger: 'blur'
          }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ],
        captcha: [
          {required: true, message: '验证码不能为空', trigger: 'blue'}
        ]
      },
      checked: false
    }
  },
  created () {
    this.getCaptcha()
  },
  methods: {
    login (event) {
      this.$refs.loginData.validate((valid) => {
        if (valid) {
          // todo 登陆逻辑
        } else {
          console.log('error submit!')
          return false
        }
      })
    },
    getCaptcha () {
      this.loginData.uuid = createUuid()
      this.captchaPath = this.$http.adornUrl(`/api/v1/captcha.jpg?uuid=${this.loginData.uuid}`)
    }
  }
}
</script>

<style scoped>
.login-container {
  width: 100%;
  height: 100%;
}
.login-page {
  -webkit-border-radius: 5px;
  border-radius: 5px;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
label.el-checkbox.rememberme {
  margin: 0px 0px 15px;
  text-align: left;
}
</style>
