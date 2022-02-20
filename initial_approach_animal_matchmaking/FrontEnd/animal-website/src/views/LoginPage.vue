<template>
  <div class="container">
    <h1 class="greet">Welcome!</h1>
    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input id="exampleInputEmail1" aria-describedby="emailHelp" class="form-control" placeholder="Enter email"
               type="email">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input id="exampleInputPassword1" class="form-control" placeholder="Password" type="password">
      </div>
      <div class="text-center mt-4">
        <button class="btn-lg btn-primary " type="submit">Submit</button>
      </div>
    </form>
    <div class="text-center mt-4"><a href="/register">
      <button class="btn-lg btn-secondary " type="submit">New User?</button>
    </a></div>
  </div>
</template>

<script>
export default {
  name: "LoginPage"
}
</script>

<style lang="scss" scoped>
.btn-primary {
  background-color: #DA88DC;
}

.btn-secondary {
  background-color: #68B7F0;
  margin-top: 2em;
}

.container {
  display: flex;
  align-items: center;
  flex-direction: column;
}

.greet {
  margin-bottom: 2em;
}
</style>