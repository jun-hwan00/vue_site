<script setup>
import { ref } from 'vue';
import PageHeader from './components/PageHeader.vue';
import SideBar from './components/SideBar.vue';
import Page1 from './views/Page1.vue';
import Page2 from "./views/Page2.vue";
import Page3 from './views/Page3.vue';

// 상태 관리
const isSidebarOpen = ref(true);
const currentPage = ref(1);

// 사이드바 토글 함수
const toggleSidebar = () => {
  isSidebarOpen.value = !isSidebarOpen.value;
};

// 페이지 변경 함수
const changePage = (pageNumber) => {
  currentPage.value = pageNumber;
};
</script>

<template>
  <div class="app-container">
    <PageHeader @toggle-sidebar="toggleSidebar" />
    
    <div class="main-content">
      <SideBar 
        :isOpen="isSidebarOpen" 
        :currentPage="currentPage"
        @change-page="changePage"
      />
      
      <div class="content-area" :class="{ 'content-expanded': !isSidebarOpen }">
        <h2 class="page-title">
          {{ currentPage === 1 ? '시작하기' : 
             currentPage === 2 ? '프로그래밍' : '학습 계획' }}
        </h2>
        
        <div class="page-content">
          <p v-if="currentPage === 1">
            환영합니다! 이 학습 노트 앱을 사용하여 학습 내용을 정리하고 관리하세요.
            왼쪽 사이드바에서 다른 페이지로 이동할 수 있습니다.
          </p>
          <p v-else-if="currentPage === 2">
            프로그래밍 관련 학습 내용을 이곳에 기록하세요.
            코드 스니펫, 개념 정리, 프로젝트 아이디어 등을 저장할 수 있습니다.
          </p>
          <p v-else>
            학습 계획을 이곳에 기록하세요.
            학습 목표, 일정, 진행 상황 등을 관리할 수 있습니다.
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Noto Sans KR', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen,
    Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

body {
  background-color: #f9fafb;
  color: #1f2937;
}

.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.main-content {
  display: flex;
  flex: 1;
  height: calc(100vh - 60px);
}

.content-area {
  flex: 1;
  padding: 1.5rem;
  transition: margin-left 0.3s;
  overflow-y: auto;
}

.content-expanded {
  margin-left: 0;
}

.page-title {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: #111827;
  border-bottom: 2px solid #e5e7eb;
  padding-bottom: 0.5rem;
}

.page-content {
  background-color: white;
  border-radius: 8px;
  padding: 1.5rem;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
  line-height: 1.6;
}
</style>
