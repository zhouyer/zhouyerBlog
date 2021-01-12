/**
 * 获取uuid
 * @author zhouyao
 * @returns {string}  格式：xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx 通常为36位，其中第15位数是4,第20位是8到b这4个中的一个
 */
export function createUuid () {
  let str = '0123456789abcdef'
  let arr = []
  for (let i = 0; i < 36; i++) {
    arr.push(str.substr(Math.floor(Math.random() * 0x10), 1))
  }
  arr[14] = 4
  arr[19] = str.substr(arr[19] & 0x3 | 0x8, 1)
  arr[8] = arr[13] = arr[18] = arr[23] = '-'
  return arr.join('')
}
