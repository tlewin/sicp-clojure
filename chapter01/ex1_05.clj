(defn p []
  (recur))

(defn test [x y]
  (if (= x 0)
      0
      y))

(test 0 (p))


;; In applicative-order it is expected an infinite loop
;; because p will be evaluated before test is called
;; On the other hand, in normal-order is expected to return 0, since
;; y will be replaced by p call and never will be executed.
