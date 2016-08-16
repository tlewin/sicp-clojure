(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(println (a-plus-abs-b 1 1)) ;; 2
(println (a-plus-abs-b 1 -1)) ;; 2

;; If b is greater than 0 then it returns "+" function
;; otherwise it returns "-" function
