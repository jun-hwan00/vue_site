<script setup>
// 이벤트 정의
const emit = defineEmits(['toggle-sidebar']);

// 사이드바 토글 이벤트 발생
const handleToggleSidebar = () => {
  emit('toggle-sidebar');
};
</script>

<template>
  <header class="page-header">
    <div class="header-left">
      <button class="sidebar-toggle" @click="handleToggleSidebar">☰</button>
      <h1 class="app-title">학습 노트</h1>
    </div>
    <div class="header-right">
      <button class="add-page-btn">+ 새 페이지</button>
    </div>
  </header>
</template>

<style scoped>
.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.5rem 1rem;
  background-color: #ffffff;
  border-bottom: 1px solid #e0e0e0;
  height: 60px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.header-left {
  display: flex;
  align-items: center;
}

.sidebar-toggle {
  background: none;
  border: none;
  font-size: 1.5rem;
  cursor: pointer;
  margin-right: 1rem;
  padding: 0.3rem;
  border-radius: 4px;
}

.sidebar-toggle:hover {
  background-color: #f0f0f0;
}

.app-title {
  font-size: 1.2rem;
  font-weight: 600;
  margin: 0;
}

.add-page-btn {
  padding: 0.5rem 1rem;
  background-color: #2563eb;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: 500;
  transition: background-color 0.2s;
}

.add-page-btn:hover {
  background-color: #1d4ed8;
}
</style>