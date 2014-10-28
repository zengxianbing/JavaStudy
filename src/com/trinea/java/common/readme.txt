1   /**
     * 去除list中重复的元素
     * 
     * @param <V>
     * @param sourceList
     * @return 去除元素的个数
     */
    public static <V> int distinctList(List<V> sourceList) {
        if (isEmpty(sourceList)) {
            return 0;
        }

        int sourceCount = sourceList.size();
        int sourceListSize = sourceList.size();
        for (int i = 0; i < sourceListSize; i++)
            for (int j = (i + 1); j < sourceListSize; j++) {
                if (sourceList.get(i).equals(sourceList.get(j))) {
                    sourceList.remove(j);
                    sourceListSize = sourceList.size();
                    j--;
                }
            }

        return sourceCount - sourceList.size();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    