(ns phone-number-test
  (:require [clojure.test :refer [deftest is]]
            phone-number))

(deftest number-tests
  (is (= "1234567890" (phone-number/number "(123) 456-7890")))
  (is (= "5558675309" (phone-number/number "555.867.5309")))
  (is (= "9876543210" (phone-number/number "19876543210")))
  (is (= "0000000000" (phone-number/number "21234567890")))
  (is (= "0000000000" (phone-number/number "123456789"))))

(deftest area-code-tests
  (is (= "123" (phone-number/area-code "1234567890")))
  (is (= "555" (phone-number/area-code "555.867.5309")))
  (is (= "987" (phone-number/area-code "(987) 654-3210")))
  (is (= "123" (phone-number/area-code "11234567890"))))

(deftest pretty-print-tests
  (is (= "(123) 456-7890" (phone-number/pretty-print "1234567890")))
  (is (= "(555) 867-5309" (phone-number/pretty-print "555.867.5309")))
  (is (= "(987) 654-3210" (phone-number/pretty-print "19876543210"))))
