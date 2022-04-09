<script setup lang="ts">
import {RouterView} from 'vue-router'
import NavBar from "@/components/navbar/NavBar.vue";</script>

<template>
  <NavBar/>
  <div class="hero-body">
    <RouterView />
  </div>
</template>

<style></style>
