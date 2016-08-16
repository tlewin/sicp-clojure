;; #'user/a
(def a 3)

;; #'user/b
(def b (+ a 1))

(do
  ;; 10
  (println 10)
  ;; 12
  (println (+ 5 3 4))
  ;; 8
  (println (- 9 1))
  ;; 3
  (println (/ 6 2))
  ;; 6
  (println (+ (* 2 4) (- 4 6)))
  ;; 19
  (println (+ a b (* a b)))
  ;; false
  (println (= a b))
  ;; 4
  (println (if (and (> b a) (< b (* a b)))
               b
               a))
  ;; 16
  (println (cond (= a 4) 6
                 (= b 4) (+ 6 7 a)
                 :else 25))
  ;; 6
  (println (+ 2 (if (> b a) b a)))
  ;; 16
  (println (* (cond (> a b) a
                    (< a b) b
                    :else -1)
              (+ a 1))))
