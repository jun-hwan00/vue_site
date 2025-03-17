<script setup>
import { ref } from 'vue';

// 페이지 내용 상태
const pageContent = ref('프로그래밍 학습 페이지입니다. 여기에서 프로그래밍 관련 학습 내용을 기록할 수 있습니다. 코드 스니펫, 알고리즘, 프레임워크 등 다양한 주제를 정리해보세요.');
const editableContent = ref('');
const isEditing = ref(false);

// 편집 시작
const startEditing = () => {
  editableContent.value = pageContent.value;
  isEditing.value = true;
};

// 편집 저장
const saveContent = () => {
  pageContent.value = editableContent.value;
  isEditing.value = false;
};

// 편집 취소
const cancelEditing = () => {
  isEditing.value = false;
};
</script>

<template>
  <div class="page">
    <div class="page-header">
      <h2>프로그래밍</h2>
      <div class="page-actions">
        <button v-if="!isEditing" @click="startEditing" class="edit-btn">편집</button>
        <template v-else>
          <button @click="cancelEditing" class="cancel-btn">취소</button>
          <button @click="saveContent" class="save-btn">저장</button>
        </template>
      </div>
    </div>
    
    <div class="page-content">
      <div v-if="!isEditing" class="content-display">
        {{ pageContent }}
      </div>
      <div v-else class="content-editor">
        <textarea v-model="editableContent" class="content-textarea"></textarea>
      </div>
    </div>
  </div>
</template>

<style scoped>
.page {
  height: 100%;
  display: flex;
  flex-direction: column;
}

.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
  padding-bottom: 1rem;
  border-bottom: 1px solid #e0e0e0;
}

.page-header h2 {
  margin: 0;
  font-size: 1.8rem;
  font-weight: 700;
  color: #111827;
}

.page-actions {
  display: flex;
  gap: 0.5rem;
}

.edit-btn, .cancel-btn, .save-btn {
  padding: 0.5rem 1rem;
  border-radius: 4px;
  cursor: pointer;
  font-size: 0.9rem;
}

.edit-btn {
  background-color: #f3f4f6;
  border: 1px solid #d1d5db;
  color: #374151;
}

.cancel-btn {
  background-color: #f3f4f6;
  border: 1px solid #d1d5db;
  color: #374151;
}

.save-btn {
  background-color: #2563eb;
  color: white;
  border: none;
}

.page-content {
  flex: 1;
}

.content-display {
  line-height: 1.6;
  color: #374151;
  font-size: 1rem;
}

.content-editor {
  height: 100%;
  min-height: 300px;
}

.content-textarea {
  width: 100%;
  height: 100%;
  min-height: 300px;
  padding: 1rem;
  border: 1px solid #d0d0d0;
  border-radius: 4px;
  font-family: inherit;
  font-size: 1rem;
  line-height: 1.6;
  resize: vertical;
}
</style>