(defn + [a b]
  (if (= a 0)
      b
      ;; we can't use `recur` here
      ;; it is only allowed on tail position
      (inc (+ (dec a) b))))

(println (+ 4 5))

;; (+ 4 5)
;; (inc (+ 3 5))
;; (inc (inc (+ 2 5)))
;; (inc (inc (inc (+ 1 5))))
;; (inc (inc (inc (inc (+ 0 5)))))
;; (inc (inc (inc (inc 5))))
;; (inc (inc (inc 6)))
;; (inc (inc 7))
;; (inc 9)
;; 9
;; recursive process


(defn + [a b]
  (if (= a 0)
      b
      (recur (dec a) (inc b))))

(println (+ 4 5))

;; (+ 4 5)
;; (+ 3 6)
;; (+ 2 7)
;; (+ 1 8)
;; (+ 0 9)
;; 9
;; iterative process
