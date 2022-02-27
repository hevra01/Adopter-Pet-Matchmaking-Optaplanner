<template>
  <NavBar/>
  <router-view v-slot="{ Component }">
    <transition name="moveInUp">
      <component :is="Component"/>
    </transition>
  </router-view>
</template>

<script>
import NavBar from "@/components/NavBar";

export default {
  name: "App",
  components: {
    NavBar,
  },
};
</script>

<style lang="scss">
#app {
  display: flex;
  justify-content: center;
  align-content: center;
  flex-direction: column;
  background-image: url("assets/master-background.png");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  min-height: 100vh;
}

.moveInUp-enter-active {
  animation: fadeIn 1s ease-in;
}

@keyframes fadeIn {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 0.5;
  }
  100% {
    opacity: 1;
  }
}

.moveInUp-leave-active {
  animation: moveInUp 0.3s ease-in;
}

@keyframes moveInUp {
  0% {
    transform: translateY(0);
  }
  100% {
    transform: translateY(-400px);
  }
}

@import "~bootstrap";
</style>
