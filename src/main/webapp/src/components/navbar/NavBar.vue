<script setup lang="ts">
</script>

<template>
  <nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <router-link  class="navbar-item" to="/">
        <img src="public/logo.png">
      </router-link>

      <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
      </a>
    </div>

    <div id="navbarBasicExample" class="navbar-menu">
      <div class="navbar-start">
        <router-link to="/" class="navbar-item">
          Garden
        </router-link>

        <router-link to="/journal" class="navbar-item">
          Journal
        </router-link>

        <router-link to="/plants" class="navbar-item">
          Plants
        </router-link>
      </div>

      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <a class="button is-primary">
              <strong>Create</strong>
            </a>
          </div>
        </div>
      </div>
    </div>
  </nav>

</template>


<style scoped>

</style>
