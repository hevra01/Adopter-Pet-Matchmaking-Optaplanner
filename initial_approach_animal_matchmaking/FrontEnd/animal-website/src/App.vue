<template>
  <div>
    <LoginPage/>
  </div>
  <router-view/>
</template>

<script>
import LoginPage from "@/views/LoginPage";

export default {
  name: "App",
  components: {
    LoginPage
  }
}
</script>

<style lang="scss">
#app {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  align-content: center;
  align-self: center;
  height: 600px;
  width: 800px;
}

body {
  background-image: url("assets/login-background.jpg");
  display: flex;
  justify-content: center;
  align-content: center;
  align-self: center;
  height: 100vh;
}

@import '~bootstrap';
</style>
