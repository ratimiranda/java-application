<script setup>
import HelloWorld from './components/HelloWorld.vue'
import ShoppingLists from './components/ShoppingLists.vue'

import axios from 'axios'
</script>

<template>
     <hr/>
<div class="container">
     <div class="row">
        <div class="col-lg-6" style="display: flex; padding-top: 64px;">
          <img alt="Vue logo" class="logo" src="./assets/grocery-logo.png" width="125" height="125" />

          <div class="wrapper">
            <HelloWorld msg="Shopping lists" />
          </div>
        </div>

        <div class="col-lg-6 shopping-lists">
          <ShoppingLists />
        </div>
    </div>
</div>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
